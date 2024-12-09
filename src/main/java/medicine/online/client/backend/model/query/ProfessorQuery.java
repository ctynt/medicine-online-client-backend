package medicine.online.client.backend.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name = "ProfessorQuery", description = "专家查询")
public class ProfessorQuery extends Query{

    @Schema(description = "目录id")
    private Integer categoryId;
}
