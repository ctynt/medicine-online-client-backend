package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "rCategoryVO", description = "分类")
public class rCategoryVO {
    @Schema(name = "pkId", description = "主键")
    private Integer pkId;
    @Schema(name = "parentId", description = "父级")
    private Integer parentId;
    @Schema(name = "title", description = "主题")
    private String title;
    @Schema(name = "sort", description = "排序")
    private Integer sort;

}
