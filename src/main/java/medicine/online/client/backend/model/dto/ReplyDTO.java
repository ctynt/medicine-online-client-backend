package medicine.online.client.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

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

    @Schema(description = "图片文件")
    private MultipartFile imgFile;
    // 新增字段用于接收上传的图片文件

    @Schema(description = "图片URL")
    // 原来的img字段可以保留，用于存储OSS URL
    private String img;
}



