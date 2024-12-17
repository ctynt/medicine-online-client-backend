package medicine.online.client.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteOrderLogVO
 */
@Data
@Schema(description = "投票记录 VO")
public class VoteOrderLogDTO {
    @Schema(description = "主键")
    private Integer pkId;
    @Schema(description = "活动id")
    private Integer activityId;
    @Schema(description = "info表id")
    private Integer infoId;
    @Schema(description = "用户")
    private Integer userId;
}
