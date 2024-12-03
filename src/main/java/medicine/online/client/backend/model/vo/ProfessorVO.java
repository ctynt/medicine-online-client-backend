package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@Data
@Schema(description = "专家列表")
public class ProfessorVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 3202639351403265115L;

    @Schema(description = "专家id")
    private Integer pkId;
    private String name;
    private String avatar;
    private String profession;
    private String majorField;
    private String brief;
}
