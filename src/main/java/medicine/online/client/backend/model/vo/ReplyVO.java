package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author WangL
 */
@Data
@Schema(description = "作答返回结果")
public class ReplyVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -6733407614700370838L;

    @Schema(description = "问题 ID")
    private Integer replyId;

    @Schema(description = "操作结果信息")
    private String message;

}
