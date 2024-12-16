package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.Exam;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/15 17:31
 * @description:
 **/
public interface ExamService extends IService<Exam> {
    List<Exam> getExamList(Integer quizDetailId);
    List<Exam> getExamsByExamineId(Integer examineId);
}
