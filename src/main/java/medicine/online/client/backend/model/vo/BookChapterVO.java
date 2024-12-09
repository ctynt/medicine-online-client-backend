package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookChapterVO
 */
@Data
@Schema(description = "书籍章节")
public class BookChapterVO {
    @Schema(description = "章节id")
    private Integer pkId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "起始页")
    private Integer startPage;
    @Schema(description = "张数")
    private Integer num;
}
