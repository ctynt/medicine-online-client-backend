package medicine.online.client.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author WangL
 */
@Data
@Schema(description = "回复问题 DTO")
public class ReplyDTO {

    @Schema(description = "用户id")
    private Integer userId;

    @Schema(description = "问题 ID")
    private Integer topicId;

    @Schema(description = "回复内容")
    private String content;

    @Schema(description = "图片文件列表")
    private List<MultipartFile> imgFile;

    @Schema(description = "图片URL列表") // 原来的img字段可以保留，用于存储OSS URL
    private List<String> img;
}



