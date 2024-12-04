package medicine.online.client.backend.model.query;
//⽤于公告分⻚查询，并且可以使⽤title 进⾏模糊筛选 ??
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name = "NewsQuery", description = "资讯查询")
public class NewsQuery extends Query{
    @Schema(description = "资讯标题")
    private String title;
}
