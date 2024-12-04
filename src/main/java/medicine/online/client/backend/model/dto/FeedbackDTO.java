package medicine.online.client.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description FeedBackVO
 */
@Data
@Schema(description = "用户反馈 DTO")
public class FeedbackDTO {
    @Schema(description = "用户id")
    private Integer userId;
    @Schema(description = "内容")
    private String content;
    @Schema(description = "类型")
    private Integer type;
    @Schema(description = "截图")
    private String img;
    @Schema(description = "练习方式")
    private String contact;
}
