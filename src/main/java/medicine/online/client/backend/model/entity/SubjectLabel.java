package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_subject_label", autoResultMap = true)
public class SubjectLabel implements Serializable {
    @Serial
    private static final long serialVersionUID = -7118493289943684477L;
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private Integer subjectId;
    private String title;
    private String brief;
    private String cover;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "category_id", typeHandler = JacksonTypeHandler.class)
    private List<Integer> categoryId;

}
