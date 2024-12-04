package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_index_category")
public class Category {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private String name;
    private Integer parentId;
    private Integer level;
    private Integer isShow;
    private Integer sort;
    private Integer type;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
