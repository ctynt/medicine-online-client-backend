package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.dto.ExamSubmitDTO;
import medicine.online.client.backend.model.entity.Exam;
import medicine.online.client.backend.model.vo.ExamResultVO;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/15 17:31
 * @description:
 **/
public interface ExamService extends IService<Exam> {
    List<Exam> getExamList(Integer quizDetailId);
    List<Exam> getExamsByExamineId(Integer examineId);

    // 添加提交试卷方法
    ExamResultVO submitExam(ExamSubmitDTO submitDTO);
}
