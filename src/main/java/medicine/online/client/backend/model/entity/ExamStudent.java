package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("t_quiz_item_exam_student")
public class ExamStudent {
    
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    
    @TableField("quiz_exam_id")
    private Integer quizExamId;
    
    @TableField("student_id")
    private Integer studentId;
    
    @TableField("quiz_student_id")
    private Integer quizStudentId;
    
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
} 