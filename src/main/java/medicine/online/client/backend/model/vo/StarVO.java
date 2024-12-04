package medicine.online.client.backend.model.vo;

import lombok.Data;
import medicine.online.client.backend.model.entity.News;

@Data
public class StarVO {
    private Integer pkId;
    private Integer contentId;
    private Integer type;
    private News info;
    // 存储关联的新闻信息
}
