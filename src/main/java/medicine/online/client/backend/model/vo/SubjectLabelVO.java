package medicine.online.client.backend.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "视频集")
public class SubjectLabelVO {
    @Schema(description = "视频集id")
    private Integer pkId;
    @Schema(description = "与t_subject的pk_id关联")
    private Integer subjectId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "标签")
    private String brief;
    @Schema(description = "封面")
    private String cover;

    @Schema(description = "与t_resource_category的pk_id关联")
    private List<Integer> categoryId;
}
