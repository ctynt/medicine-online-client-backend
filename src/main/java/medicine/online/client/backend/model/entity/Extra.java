package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description Extra
 */
@Data
@TableName("t_extra")
public class Extra {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private Integer type;
    private String content;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
