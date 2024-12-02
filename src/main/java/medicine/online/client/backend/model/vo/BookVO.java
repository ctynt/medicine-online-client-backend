package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "bookVO", description = "图书信息")
public class BookVO {
    @Schema(description = "主键")
    private Integer pkId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "封面")
    private String cover;
    @Schema(description = "浏览量")
    private Integer browseNum;
//    @Schema(description = "categoryId")
//    private Integer categoryId;

}
