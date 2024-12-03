package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookCategoryVO
 */
@Data
@Schema(description = "书籍分类 VO")
public class BookCategoryVO {
    @Schema(description = "书籍id")
    private Integer pkId;
    @Schema(description = "标题")
    private String title;
}
