package medicine.online.client.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "开始考试请求参数")
public class StartExamDTO {
    
    @Schema(description = "考试ID")
    @NotNull(message = "考试ID不能为空")
    private Integer examId;
    
    @Schema(description = "学生ID")
    @NotNull(message = "学生ID不能为空")
    private Integer studentId;
} 