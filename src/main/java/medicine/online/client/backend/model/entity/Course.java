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
@TableName(value = "t_course", autoResultMap = true)
public class Course implements Serializable {
    @Serial
    private static final long serialVersionUID = -7118493289943684477L;
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private String title;
    private Integer sort;
    private String cover;
    private String brief;
    private String authorAvatar;
    private String authorBrief;
    private String authorProfession;
    private String label;
    private String author;
    private Integer maxStudyTime;
    private Integer browseNum;
    private Integer starNum;
    private Integer managerId;
    private Integer state;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    private Integer categoryId;
    private Integer deleteFlag;

}
