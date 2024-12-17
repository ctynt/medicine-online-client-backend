package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteOrderVO
 */
@Data
@Schema(description = "投票排名 VO")
public class VoteOrderVO {
    @Schema(description = "主键")
    private Integer pkId;
    @Schema(description = "活动id")
    private Integer activityId;
    @Schema(description = "用户id")
    private Integer userId;
    @Schema(description = "排名名次")
    private Integer range;
}
