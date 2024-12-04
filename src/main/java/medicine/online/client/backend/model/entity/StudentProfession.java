package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/2
 * @Description StudentProfession
 */
@Data
@TableName("t_student_profession")
public class StudentProfession {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private String name;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
