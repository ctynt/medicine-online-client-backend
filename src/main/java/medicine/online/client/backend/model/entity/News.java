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
@TableName(value = "t_news", autoResultMap = true)
//该类实现了Serializable接口，以便能够在网络传输或存储到文件等场景下进行序列化和反序列化操作。
public class News implements Serializable  {
    @Serial
    private static final long serialVersionUID = -7118493289943684477L;
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private String title;
    private String cover;
    private String source;
    private String label;
    private Integer browseNum;
    private Integer maxStudyTime;
    private String content;
    private Integer starNum;
    private Integer state;
    private Integer managerId;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
