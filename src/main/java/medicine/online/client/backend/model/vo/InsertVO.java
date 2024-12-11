package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author：
 * @description：发起提问返回结果 VO
 */
@Data
@Schema(description = "发起提问返回结果")
public class InsertVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -2793849947459881032L;

    @Schema(description = "问题 ID")
    private Integer topicId;

    @Schema(description = "操作结果信息")
    private String message;
}
