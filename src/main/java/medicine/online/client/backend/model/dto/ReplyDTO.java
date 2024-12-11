package medicine.online.client.backend.model.dto;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author WangL
 */
@Data
@Schema(description = "发起提问 DTO")
public class ReplyDTO {

    @Schema(description = "用户id")
    private Integer userId;

    @Schema(description = "问题 ID")
    private Integer topicId;

    @Schema(description = "回复内容")
    private String content;

    @Schema(description = "图片视频")
    private String img;
}
