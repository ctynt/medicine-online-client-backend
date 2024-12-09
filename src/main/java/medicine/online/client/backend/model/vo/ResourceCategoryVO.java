package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import medicine.online.client.backend.common.model.TreeNode;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description ResourceCategoryVO
 */
@Data
@Schema(description = "资源分类")
public class ResourceCategoryVO extends TreeNode<ResourceCategoryVO> {
    @Schema(description = "资源Id")
    private Integer pkId;
    @Schema(description = "父节点")
    private Integer parentId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "排序")
    private Integer sort;
}
