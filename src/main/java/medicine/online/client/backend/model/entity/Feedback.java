package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description FeedBack
 */
@Data
@TableName("t_feedback")
public class Feedback {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private Integer userId;
    private String content;
    private String img;
    private Integer type;
    private String contact;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
