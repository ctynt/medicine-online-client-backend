package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: minder
 * @createTime: 2024/12/16 15:55
 * @description:
 **/
@Data
@Schema(description = "试卷信息")
public class ExamVO {
    @Schema(description = "主键")
    private Integer pkId;
    @Schema(description = "外键")
    private Integer quizDetailId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "描述")
    private String brief;
    @Schema(description = "封面")
    private String cover;
    @Schema(description = "限制时间")
    private Integer timeLimit;
    @Schema(description = "标题")
    private String paperTitle;

    @Schema(description = "开始时间")
    private LocalDateTime startTime;
    @Schema(description = "结束时间")
    private LocalDateTime endTime;
}
