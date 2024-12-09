package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@Data
@Schema(description = "专家目录分类")
public class ProfessorCategoryVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1027233597219255925L;

    @Schema(description = "专家目录id")
    private Integer pkId;
    @Schema(description = "专家目录名称")
    private String name;
    @Schema(description = "专家目录封面")
    private String cover;
    // 存储子分类列表
    private List<ProfessorCategoryVO> childCategory;
}
