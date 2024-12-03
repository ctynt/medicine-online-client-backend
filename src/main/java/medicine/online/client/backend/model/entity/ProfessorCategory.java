package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@Data
@TableName("t_professor_category")
public class ProfessorCategory {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private String name;
    private String cover;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private byte level;
    private Integer parentId;
    private Integer sort;
}
