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
@Schema(description = "专家列表")
public class ProfessorVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 3202639351403265115L;

    @Schema(description = "专家id")
    private Integer pkId;
    @Schema(description = "专家姓名")
    private String name;
    @Schema(description = "专家头像")
    private String avatar;
    @Schema(description = "专家职称")
    private String profession;
    @Schema(description = "专家擅长领域")
    private String majorField;
    @Schema(description = "专家简介")
    private String brief;
}
