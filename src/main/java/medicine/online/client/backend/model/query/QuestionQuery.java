package medicine.online.client.backend.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: minder
 * @createTime: 2024/12/15 20:53
 * @description:
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name = "QuestionQuery", description = "题库查询")
public class QuestionQuery extends Query{

    @Schema(description = "试卷ID")
    private Integer paperId;
    
    @Schema(description = "考试ID")
    private Integer quizExamId;
}
