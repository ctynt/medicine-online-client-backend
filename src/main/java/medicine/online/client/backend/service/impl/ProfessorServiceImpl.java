package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.enums.TopicStatusEnum;
import medicine.online.client.backend.mapper.*;
import medicine.online.client.backend.model.entity.*;
import medicine.online.client.backend.model.vo.ProfessorDetailVO;
import medicine.online.client.backend.model.vo.ProfessorVO;
import medicine.online.client.backend.model.vo.TopicVO;
import medicine.online.client.backend.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@Slf4j
@Service
@AllArgsConstructor
public class ProfessorServiceImpl extends ServiceImpl<ProfessorMapper, Professor> implements ProfessorService {
    private final UserMapper userMapper;
    private final StudentMapper studentMapper;
    private final ProfessorMapper professorMapper;
    private final StudentProfessionMapper studentProfessionMapper;
    private final ProfessorCategoryMapper professorCategoryMapper;
    private final TopicMapper topicMapper;

    @Override
    public List<ProfessorVO> getProfessorList(Integer categoryId) {
        return professorMapper.selectByCategoryId(categoryId);
    }

    @Override
    public ProfessorDetailVO getProfessorDetail(Integer id) {
        LambdaQueryWrapper<Topic> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Topic::getProfessorId, id).eq(Topic::getDeleteFlag, 0);
        List<Topic> topics = topicMapper.selectList(queryWrapper);
        List<TopicVO> topicVOS = topics.stream().map(topic -> {
            TopicVO topicVO = new TopicVO();
            topicVO.setContent(topic.getContent());
            topicVO.setCreateTime(topic.getCreateTime());
            topicVO.setStatus(TopicStatusEnum.getDescription(topic.getStatus()));
            topicVO.setPkId(topic.getPkId());
            User user = userMapper.selectById(topic.getUserId());
            topicVO.setAvatar(user.getAvatar());
            topicVO.setName(user.getNickname());
            Professor professor = professorMapper.selectById(topic.getProfessorId());
            ProfessorCategory category = professorCategoryMapper.selectById(professor.getCategoryId());
            LambdaQueryWrapper<Student> studentQueryWrapper = new LambdaQueryWrapper<>();
            studentQueryWrapper.eq(Student::getPhone, user.getPhone());
            Student student = studentMapper.selectOne(studentQueryWrapper);
            StudentProfession studentProfession = studentProfessionMapper.selectById(student.getProfessionId());
            topicVO.setTag(category.getName() + " " + studentProfession.getName());
            topicVO.setImg(topic.getImg());
            return topicVO;
        }).collect(Collectors.toList());
        Professor professor = professorMapper.selectById(id);
        ProfessorDetailVO professorDetailVO = new ProfessorDetailVO();
        professorDetailVO.setPkId(professor.getPkId());
        professorDetailVO.setName(professor.getName());
        LambdaQueryWrapper<User> queryWrapper1 = new LambdaQueryWrapper<>();
        queryWrapper1.eq(User::getPhone, professor.getPhone());
        User user1 = userMapper.selectOne(queryWrapper1);
        if (user1 != null) {
            professorDetailVO.setUserId(String.valueOf(user1.getPkId()));
        } else {
            professorDetailVO.setUserId("0");
        }
        professorDetailVO.setName(professor.getName());
        professorDetailVO.setAvatar(professor.getAvatar());
        professorDetailVO.setTitle(professor.getTitle());
        professorDetailVO.setProfession(professor.getProfession());
        professorDetailVO.setMajorField(professor.getMajorField());
        professorDetailVO.setBrief(professor.getBrief());
        professorDetailVO.setExperience(professor.getExperience());
        professorDetailVO.setDepartment(professor.getHospital());
        professorDetailVO.setList(topicVOS);
        return professorDetailVO;
    }
}
