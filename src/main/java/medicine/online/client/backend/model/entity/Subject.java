package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_subject", autoResultMap = true)
public class Subject implements Serializable {
    @Serial
    private static final long serialVersionUID = -7118493289943684477L;
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private String title;
    private String brief;
    private String cover;
    private String label;
    private String claim;
    // 最大学习时长
    private Integer maxStudyTime;
    private Integer browseNum;
    private Integer starNum;
    private Integer state;
    private Integer managerId;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    private Integer isExam;
    @TableField(value = "start_time", fill = FieldFill.INSERT)
    private LocalDateTime startTime;
    @TableField(value = "end_time", fill = FieldFill.INSERT)
    private LocalDateTime endTime;
    private Integer type;


}
