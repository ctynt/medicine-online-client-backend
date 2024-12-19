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
@Schema(description = "考试结果")
public class ExamResultVO {

    @Schema(description = "试卷总分")
    private Integer totalScore;

    @Schema(description = "实际得分")
    private Integer score;

    @Schema(description = "正确题目数")
    private Integer correctCount;

    @Schema(description = "总题目数")
    private Integer totalCount;

    @Schema(description = "及格分数")
    private Integer passScore;

    @Schema(description = "是否及格")
    private Boolean isPassed;
}
