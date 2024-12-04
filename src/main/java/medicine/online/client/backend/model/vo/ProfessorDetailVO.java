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
@Schema(description = "专家详情")
public class ProfessorDetailVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 6545881098344509116L;

    @Schema(description = "专家id")
    private Integer pkId;
    @Schema(description = "专家用户id")
    private String userId;
    @Schema(description = "专家姓名")
    private String name;
    @Schema(description = "专家头像")
    private String avatar;
    @Schema(description = "专家职称")
    private String title;
    @Schema(description = "专家专业")
    private String profession;
    @Schema(description = "专家擅长领域")
    private String majorField;
    @Schema(description = "专家简介")
    private String brief;
    @Schema(description = "专家履历")
    private String experience;
    @Schema(description = "工作单位")
    private String department;

    private List<TopicVO> list;
}
