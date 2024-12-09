package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 12862
 */
@Data
@Schema(name = "CategoryVO", description = "分类返回vo")
public class CategoryVO {
    @Schema(name = "pkId", description = "主键")
    private Integer pkId;
    @Schema(name = "name", description = "标题")
    private String name;
    @Schema(name = "level", description = "层级")
    private Integer level;
    @Schema(name = "parentId", description = "父级id")
    private Integer parentId;
    @Schema(name = "isShow", description = "是否显示")
    private Integer isShow;
    @Schema(name = "sort", description = "排序")
    private Integer sort;
    @Schema(name = "type", description = "类型")
    private Integer type;
}
