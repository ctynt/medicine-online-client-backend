package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "PodcastVo", description = "音频返回vo")
public class PodcastVO {
    @Schema(description = "主键")
    private Integer pkId;

    private String title;

    private String label;

    private Integer browseNum;
}
