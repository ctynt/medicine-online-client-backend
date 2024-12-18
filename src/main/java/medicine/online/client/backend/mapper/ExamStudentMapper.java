package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.ExamStudent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ExamStudentMapper extends BaseMapper<ExamStudent> {
    
    @Select("SELECT * FROM t_quiz_item_exam_student WHERE quiz_exam_id = #{examId} AND student_id = #{studentId} LIMIT 1")
    ExamStudent findByExamIdAndStudentId(@Param("examId") Integer examId, @Param("studentId") Integer studentId);
} 