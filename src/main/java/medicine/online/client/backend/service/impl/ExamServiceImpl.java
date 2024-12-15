package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import medicine.online.client.backend.mapper.ExamMapper;
import medicine.online.client.backend.model.entity.Exam;
import medicine.online.client.backend.service.ExamService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/15 17:32
 * @description:
 **/
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
    @Resource
    private ExamMapper examMapper;
    @Override
    public List<Exam> getExamList(Integer quizDetailId) {
        return examMapper.selectExamByDetailId(quizDetailId);
    }
}
