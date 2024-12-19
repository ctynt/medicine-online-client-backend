package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteInfoVO
 */
@Data
@Schema(description = "投票信息 VO")
public class VoteInfoVO {
    @Schema(description = "主键")
    private Integer pkId;
    @Schema(description = "名称")
    private String name;
    @Schema(description = "简介")
    private String intro;
    @Schema(description = "封面")
    private String cover;
    @Schema(description = "票数")
    private Integer num;
    @Schema(description = "占比")
    private Double proportion;
    @Schema(description = "活动id")
    private Integer activityId;
}
