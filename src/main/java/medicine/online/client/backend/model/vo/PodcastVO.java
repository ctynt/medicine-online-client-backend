package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

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
    @Schema(description = "收藏量")
    private Integer starNum;
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;
    private Integer leixing;
}
