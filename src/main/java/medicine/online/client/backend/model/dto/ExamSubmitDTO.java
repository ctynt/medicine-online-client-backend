package medicine.online.client.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/18 1:19
 * @description:
 **/
@Data
@Schema(description = "考试提交")
public class ExamSubmitDTO {
    @Schema(description = "试卷ID")
    private Integer examId;

    @Schema(description = "卷类型ID")
    private Integer paperId;

    @Schema(description = "答案列表")
    private List<AnswerDTO> answers;
}

