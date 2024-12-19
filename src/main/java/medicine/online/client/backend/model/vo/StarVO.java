package medicine.online.client.backend.model.vo;

import lombok.Data;
import medicine.online.client.backend.model.entity.Course;
import medicine.online.client.backend.model.entity.News;
import medicine.online.client.backend.model.entity.Podcast;

@Data
public class StarVO {
    private Integer userId;
    private Integer pkId;
    private Integer contentId;
    private Integer type;
    private News info;
    private Podcast info1;
    private Course info2;
    // 存储关联的新闻信息
}
