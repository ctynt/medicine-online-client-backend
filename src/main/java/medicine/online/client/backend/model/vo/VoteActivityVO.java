package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteActivityVO
 */
@Data
@Schema(description = "投票活动 VO")
public class VoteActivityVO {
    @Schema(description = "主键")
    private Integer pkId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "开始时间")
    private LocalDateTime startTime;
    @Schema(description = "结束时间")
    private LocalDateTime endTime;
    @Schema(description = "参与人数")
    private Integer participation;
    @Schema(description = "标签")
    private Integer tag;
    @Schema(description = "封面")
    private String cover;
    @Schema(description = "类型")
    private Integer type;
}
