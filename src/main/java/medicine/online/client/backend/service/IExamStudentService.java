package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.ExamStudent;

/**
 * 考试学生服务接口
 *
 * @author minder
 */
public interface IExamStudentService extends IService<ExamStudent> {
    /**
     * 记录学生开始考试
     * @param examId 考试ID (t_quiz_item_exam的pk_id)
     * @param studentId 学生ID
     * @return 是否成功创建考试记录
     */
    boolean startExam(Integer examId, Integer studentId);
    
    /**
     * 获取考试答题记录
     * @param detail 答题详情ID
     * @return Redis中存储的答题记录
     */
    String getQuizUserDetail(String detail);

    /**
     * 保存试卷访问记录到Redis
     * @param examId 考试ID (t_quiz_item_exam的pk_id)
     */
    void saveQuizUserPaperId(Integer examId);
} 