package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/11/26
 * @Description Student
 */
@Data
@TableName("t_student")
public class Student {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private String name;
    private Integer sex;
    private Integer age;
    private String licence;
    private String hospital;
    private Integer professionId;
    private Integer cityCode;
    private String phone;
    private Integer isTest;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
