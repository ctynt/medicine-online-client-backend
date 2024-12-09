package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author WangL
 */
@Data
@TableName("t_user_star")
public class Star {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private Integer userId;
    private Integer type;
    private Integer contentId;

    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    private Integer deleteFlag;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
