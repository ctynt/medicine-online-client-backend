package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 16:01
 * @description:
 **/
@Data
@TableName("t_quiz_bank_option")
public class BankOption {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private String bankId;
    private String option;
    private String content;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

}
