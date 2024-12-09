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
@TableName("t_topic_reply")
public class TopicReply {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private Integer userId;
    private Integer topicId;
    private String content;
    private String img;
    private Integer judgeStatus;
    private Integer deleteFlag;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
