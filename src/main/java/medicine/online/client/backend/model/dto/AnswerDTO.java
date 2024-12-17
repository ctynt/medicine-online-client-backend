package medicine.online.client.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: minder
 * @createTime: 2024/12/18 1:20
 * @description:
 **/
@Data
@Schema(description = "答案详情")
public class AnswerDTO {
    @Schema(description = "题目ID")
    private Integer pkId;

    @Schema(description = "题目类型(0:单选,1:多选,2:填空)")
    private Integer optionType;

    @Schema(description = "答案")
    private String answer;
}
