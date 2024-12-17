package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 14:58
 * @description:
 **/
@Data
@TableName("t_quiz")
public class Quiz {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private String title;
    private String brief;
    private String cover;
    private String state;
    private String certificateUrl;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
