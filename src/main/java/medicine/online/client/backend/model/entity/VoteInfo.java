package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteInfo
 */
@Data
@TableName("t_vote_info")
public class VoteInfo {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private String name;
    private String intro;
    private String cover;
    private Integer num;
    private Double proportion;
    private Integer activityId;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableLogic
    private Integer deleteFlag;
}
