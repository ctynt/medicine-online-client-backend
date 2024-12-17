package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 15:53
 * @description:
 **/
@Data
@TableName("t_quiz_bank")
public class Bank {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private Integer optionType;
    private String question;
    private String answer;
    private Integer wordLimit;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    List<BankOption> bankOptions;
}
