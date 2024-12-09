package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "NewsVo", description = "资讯返回vo")
public class NewsVO {
    @Schema(description = "主键")
    private Integer pkId;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "封面")
    private String cover;

    @Schema(description = "来源")
    private String source;

    @Schema(description = "标签")
    private String label;

    @Schema(description = "浏览量")
    private Integer browseNum;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "收藏量")
    private Integer starNum;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    private Integer leixing;
}
