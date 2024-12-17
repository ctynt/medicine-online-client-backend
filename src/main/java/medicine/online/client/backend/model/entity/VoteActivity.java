package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteActivity
 */
@Data
@TableName("t_vote_activity")
public class VoteActivity {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer participation;
    private Integer tag;
    private String cover;
    private Integer type;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private Integer deleteFlag;
}
