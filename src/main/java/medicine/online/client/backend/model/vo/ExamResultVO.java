package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author: minder
 * @createTime: 2024/12/18 1:21
 * @description:
 **/
@Data
@Builder
@Schema(description = "考试结果")
public class ExamResultVO {
    @Schema(description = "总分")
    private Integer totalScore;

    @Schema(description = "得分")
    private Integer score;

    @Schema(description = "正确题数")
    private Integer correctCount;

    @Schema(description = "题目总数")
    private Integer totalCount;
}
