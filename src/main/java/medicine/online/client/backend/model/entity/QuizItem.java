package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: minder
 * @createTime: 2024/12/13 15:34
 * @description:
 **/
@Data
@TableName("t_quiz_item")
public class QuizItem {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private Integer examineId;
    private Integer type;
    private String name;
    private String brief;
    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
