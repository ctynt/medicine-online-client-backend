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
@TableName("t_professor")
public class Professor {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private Integer categoryId;
    private String hospital;
    private String name;
    private String title;
    private String profession;
    private String majorField;
    private Integer sex;
    private String birth;
    private String phone;
    private String avatar;
    private String brief;
    private String experience;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;
}
