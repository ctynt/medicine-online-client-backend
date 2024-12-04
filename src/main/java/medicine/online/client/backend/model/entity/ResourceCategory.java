package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description ResourceCategory
 */
@Data
@TableName("t_resource_category")
public class ResourceCategory {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private Integer parentId;
    private String title;
    private Integer sort;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
