package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.enums.TopicStatusEnum;
import medicine.online.client.backend.mapper.*;
import medicine.online.client.backend.model.dto.InsertDTO;
import medicine.online.client.backend.model.dto.ReplyDTO;
import medicine.online.client.backend.model.entity.*;
import medicine.online.client.backend.model.vo.InsertVO;
import medicine.online.client.backend.model.vo.ReplyVO;
import medicine.online.client.backend.model.vo.TopicVO;
import medicine.online.client.backend.service.ProfessorService;
import medicine.online.client.backend.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author： Lance
 * @create： 2024/12/9
 * @Description TopicServiceImpl
 **/

@Slf4j
@Service
@AllArgsConstructor
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {
    private final TopicMapper topicMapper;
    private final TopicReplyMapper topicReplyMapper;
    private final ProfessorService professorService;
    private final UserMapper userMapper;
    private final ProfessorCategoryMapper professorCategoryMapper;
    private final StudentMapper studentMapper;
    private final StudentProfessionMapper studentProfessionMapper;
    private final OssServiceImpl ossService;

    @Override
    public List<TopicVO> getTopicList(Integer id) {
        // 根据教授ID查询相关的Topic
        List<Topic> topics = topicMapper.selectList(new LambdaQueryWrapper<Topic>()
                .eq(Topic::getProfessorId, id)
                .eq(Topic::getDeleteFlag, 0));
        // 排除已删除的记录

        // 将 Topic 转换为 TopicVO
        return topics.stream().map(topic -> {
            TopicVO topicVO = new TopicVO();
            topicVO.setContent(topic.getContent());
            topicVO.setCreateTime(topic.getCreateTime());
            topicVO.setStatus(TopicStatusEnum.getDescription(topic.getStatus()));
            // 将Topic状态转换为描述

            topicVO.setPkId(topic.getPkId());

            // 获取 Topic 的提问者信息
            User user = userMapper.selectById(topic.getUserId());
            topicVO.setAvatar(user.getAvatar());
            topicVO.setName(user.getNickname());

            // 获取教授信息
            Professor professor = professorService.getById(topic.getProfessorId());
            ProfessorCategory category = professorCategoryMapper.selectById(professor.getCategoryId());

            // 获取学生信息
            LambdaQueryWrapper<Student> studentQueryWrapper = new LambdaQueryWrapper<>();
            studentQueryWrapper.eq(Student::getPhone, user.getPhone());
            Student student = studentMapper.selectOne(studentQueryWrapper);
            StudentProfession studentProfession = studentProfessionMapper.selectById(student.getProfessionId());

            // 设置 Topic 标签（类别 + 学生专业）
            topicVO.setTag(category.getName() + " " + studentProfession.getName());
            topicVO.setImg(topic.getImg());
            return topicVO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> getTopicReplyList(Integer id) {
        // 根据 TopicID 查询相关的 TopicReply
        List<TopicReply> replies = topicReplyMapper.selectList(new LambdaQueryWrapper<TopicReply>()
                .eq(TopicReply::getTopicId, id)
                .eq(TopicReply::getDeleteFlag, 0));
        // 排除已删除的记录

        // 构造返回数据
        return replies.stream().map(reply -> {
            // 查询用户信息
            User user = userMapper.selectById(reply.getUserId());

            // 构造返回的 Map 数据结构
            Map<String, Object> replyData = new HashMap<>();
            replyData.put("avatar", user != null ? user.getAvatar() : "");
            replyData.put("content", reply.getContent());
            replyData.put("name", user != null ? user.getNickname() : "未知用户");
            replyData.put("img", reply.getImg());
            replyData.put("createTime", reply.getCreateTime());

            return replyData;
        }).collect(Collectors.toList());
    }

    @Override
    public InsertVO submitQuestion(InsertDTO submitQuestionDTO) {
        Integer userId = submitQuestionDTO.getUserId();
        Integer professorId = submitQuestionDTO.getProfessorId();
        String content = submitQuestionDTO.getContent();
        MultipartFile imgFile = submitQuestionDTO.getImgFile();

        // 校验用户是否存在
        User user = userMapper.selectById(userId);
        if (user == null) {
            throw new IllegalArgumentException("用户不存在");
        }

        // 校验教授是否存在
        Professor professor = professorService.getById(professorId);
        if (professor == null) {
            throw new IllegalArgumentException("教授不存在");
        }

        // 校验问题内容是否为空
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("问题内容不能为空");
        }

        // 上传图片到OSS
        String img = "";
        if (imgFile != null && !imgFile.isEmpty()) {
            try {
                img = ossService.uploadFile(imgFile);
            } catch (IOException e) {
                log.error("上传图片失败", e);
                throw new RuntimeException("上传图片失败", e);
            }
        }

        // 创建新的 Topic 实体对象
        Topic topic = new Topic();
        topic.setUserId(userId);
        topic.setProfessorId(professorId);
        topic.setContent(content);
        topic.setImg(img);
        // 保存OSS URL
        topic.setStatus(0);
        // 2不予回答，1已回答，0未回答，默认为0
        topic.setRemark("");
        // 默认为空
        topic.setJudgeStatus(0);
        // 0待审核，1审核失败，2已审核，默认为 0
        topic.setDeleteFlag(0);
        // 默认未删除
        topic.setCreateTime(LocalDateTime.now());
        topic.setUpdateTime(LocalDateTime.now());

        // 插入数据到数据库
        topicMapper.insert(topic);

        // 构造返回结果 VO
        InsertVO responseVO = new InsertVO();
        responseVO.setTopicId(topic.getPkId());
        responseVO.setMessage("提问成功，待审核");

        return responseVO;
    }

    @Override
    public ReplyVO replyToTopic(ReplyDTO replyDTO) {
        // 校验问题是否存在
        Topic topic = topicMapper.selectById(replyDTO.getTopicId());
        if (topic == null || topic.getDeleteFlag() == 1) {
            throw new IllegalArgumentException("问题不存在或已被删除");
        }

        // 校验回复内容
        if (replyDTO.getContent() == null || replyDTO.getContent().isEmpty()) {
            throw new IllegalArgumentException("回复内容不能为空");
        }

        // 上传图片到OSS
        String img = "";
        if (replyDTO.getImgFile() != null && !replyDTO.getImgFile().isEmpty()) {
            try {
                img = ossService.uploadFile(replyDTO.getImgFile());
            } catch (IOException e) {
                log.error("上传图片失败", e);
                throw new RuntimeException("上传图片失败", e);
            }
        }

        // 创建新的回复记录
        TopicReply reply = new TopicReply();
        reply.setUserId(replyDTO.getUserId());
        reply.setTopicId(replyDTO.getTopicId());
        reply.setContent(replyDTO.getContent());
        reply.setImg(img); // 保存OSS URL
        reply.setJudgeStatus(0);
        // 默认未审核
        reply.setDeleteFlag(0);
        // 默认未删除
        reply.setCreateTime(LocalDateTime.now());
        reply.setUpdateTime(LocalDateTime.now());

        // 插入数据库
        topicReplyMapper.insert(reply);

        // 返回结果
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyId(reply.getPkId());
        replyVO.setMessage("回复成功，待审核");

        return replyVO;
    }


}
