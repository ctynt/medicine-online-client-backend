package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "SubjectVO", description = "专题信息")
public class SubjectVO {
    @Schema(description = "主键")
    private Integer pkId;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "封面")
    private String cover;

    @Schema(description = "标签")
    private String label;

    @Schema(description = "浏览量")
    private Integer browseNum;

    @Schema(description = "收藏量")
    private Integer starNum;

    @Schema(description = "简介")
    private String brief;

    @Schema(description = "学习要求")
    private String claim;

    @Schema(description = "类型")
    private Integer type;

    private Integer leixing;
}
