package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "CourseVideoVO", description = "课程视频信息")
public class CourseVideoVO {
    @Schema(description = "主键")
    private Integer pkId;
    @Schema(description = "课程id")
    private Integer courseId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "路径")
    private String url;

    @Schema(description = "逻辑删除")
    private Integer deleteFlag;

}
