package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "PodcastVo", description = "音频返回vo")
public class PodcastVO {
    @Schema(description = "主键")
    private Integer pkId;
    @Schema(description = "主题")
    private String title;
    @Schema(description = "封面")
    private String cover;
    @Schema(description = "标签")
    private String label;
    @Schema(description = "浏览量")
    private Integer browseNum;
    @Schema(description = "图片url")
    private String cover;

    private Integer leixing;
}
