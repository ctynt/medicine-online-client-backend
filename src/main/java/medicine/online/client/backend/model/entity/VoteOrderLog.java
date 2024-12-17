package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteOrderLog
 */
@Data
@TableName("t_vote_order_log")
public class VoteOrderLog {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private Integer activityId;

    private Integer infoId;
    private Integer userId;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableLogic
    private Integer deleteFlag;
}
