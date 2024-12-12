package medicine.online.client.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author WangL
 */
@Data
@Schema(description = "发起提问 DTO")
public class InsertDTO {

    @Schema(description = "用户id")
    private Integer userId;

    @Schema(description = "教授 id")
    private Integer professorId;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "图片文件列表")
    private List<MultipartFile> imgFile;

    @Schema(description = "图片URL列表") // 原来的img字段可以保留，用于存储OSS URL
    private List<String> img;
}



