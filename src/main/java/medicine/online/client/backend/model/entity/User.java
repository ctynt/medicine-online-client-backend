package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import medicine.online.client.backend.enums.AccountStatusEnum;

import java.time.LocalDateTime;

@Data
@TableName("t_user")
public class User {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private String nickname;
    private String avatar;
    private String slogan;
    private String phone;
    private String openId;
    private String unionId;
    /**
     * @see AccountStatusEnum
     */
    private Integer isEnable;

    // 角色Id
    private Integer role;
    // 学员表Id
    private Integer roleId;
    private Integer province;
    private Integer city;
    private Integer area;
    private Integer hospital;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
