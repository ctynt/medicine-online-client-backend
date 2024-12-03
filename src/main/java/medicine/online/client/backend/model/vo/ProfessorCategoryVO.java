package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@Data
@Schema(description = "专家目录分类")
public class ProfessorCategoryVO {
    private Integer pkId;
    private String name;
    private String cover;
    private List<ProfessorCategoryVO> childCategory; // 存储子分类列表
}
