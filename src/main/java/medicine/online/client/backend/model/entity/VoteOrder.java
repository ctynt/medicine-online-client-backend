package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteOrder
 */
@Data
@TableName("t_vote_order")
public class VoteOrder {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private Integer activityId;
    private Integer userId;
    private Integer range;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableLogic
    private Integer deleteFlag;
}
