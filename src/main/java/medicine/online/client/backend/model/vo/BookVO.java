package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookVO
 */
@Data
@Schema(description = "书籍信息")
public class BookVO {
    @Schema(description = "主键")
    private Integer pkId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "封面")
    private String cover;
    @Schema(description = "浏览量")
    private Integer browseNum;
    @Schema(description = "总共页数")
    private Integer totalPage;
    @Schema(description = "书籍url")
    private String url;
    
    private Integer leixing;
}