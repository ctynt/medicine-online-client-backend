package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: minder
 * @createTime: 2024/12/13 15:51
 * @description:
 **/
@Data
@TableName("t_quiz_paper")
public class Paper {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private Integer quizExamId;
    private String title;
    private Integer timeLimit;
    private Integer simpleScore;
    private Integer multipleScore;
    private Integer blankScore;
    private Integer score;
    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
