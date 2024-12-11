package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ctynt
 * @Date 2024/12/11
 * @Description PodcastAudioVO
 */
@Data
@Schema(description = "音频资源 VO")
public class PodcastAudioVO {
    @Schema(description = "主键")
    private Integer pkId;
    @Schema(description = "音频id")
    private Integer podcastId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "视频长度")
    private Integer length;
    @Schema(description = "排序")
    private Integer sort;
    @Schema(description = "音频url")
    private String url;
}
