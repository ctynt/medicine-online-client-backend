package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.enums.TopicStatusEnum;
import medicine.online.client.backend.mapper.*;
import medicine.online.client.backend.model.entity.*;
import medicine.online.client.backend.model.vo.TopicVO;
import medicine.online.client.backend.service.ProfessorService;
import medicine.online.client.backend.service.TopicService;
import org.springframework.stereotype.Service;

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
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService{
    private final TopicMapper topicMapper;
    private final TopicReplyMapper topicReplyMapper;
    private final ProfessorService professorService;
    private final UserMapper userMapper;
    private final ProfessorCategoryMapper professorCategoryMapper;
    private final StudentMapper studentMapper;
    private final StudentProfessionMapper studentProfessionMapper;

    @Override
    public List<TopicVO> getTopicList(Integer id) {
        // 根据教授ID查询相关的Topic
        List<Topic> topics = topicMapper.selectList(new LambdaQueryWrapper<Topic>()
                .eq(Topic::getProfessorId,id)
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
        // 根据 Topic ID 查询相关的 TopicReply
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
}
