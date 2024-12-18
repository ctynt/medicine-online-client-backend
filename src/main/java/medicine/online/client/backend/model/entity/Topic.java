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
@TableName("t_topic")
public class Topic {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private Integer userId;
    private Integer professorId;
    private String content;
    private String img;
    /**
     * @see medicine.online.client.backend.enums.TopicStatusEnum
     */
    private Integer status;
    private String remark;
    private Integer judgeStatus;

    @TableField(value = "delete_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleteFlag;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
