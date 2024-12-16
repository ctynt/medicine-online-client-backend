package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_course_video", autoResultMap = true)
public class CourseVideo {
    @Serial
    private static final long serialVersionUID = -7118493289943684477L;
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private Integer courseId;
    private String title;
    private Integer length;
    private String url;
    private Integer sort;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private Integer deleteFlag;
}
