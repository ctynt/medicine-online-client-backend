package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 15:37
 * @description:
 **/
@Data
@TableName("t_quiz_item_exam")
public class Exam {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    @TableField("quiz_detail_id")
    private Integer quizDetailId;
    private String title;
    private String brief;
    private String cover;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer isStart;
    @TableField(exist = false)
    private List<Paper> papers;
    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
