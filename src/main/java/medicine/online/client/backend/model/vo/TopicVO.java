package medicine.online.client.backend.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@Data
@Schema(description = "问题")
public class TopicVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8140267690794611428L;

    @Schema(description = "问题名")
    private String content;
    @Schema(name = "createTime", description = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @Schema(description = "问题是否回答")
    private String status;
    @Schema(description = "问题id")
    private Integer pkId;
    @Schema(description = "头像")
    private String avatar;
    @Schema(description = "提问者")
    private String name;
    @Schema(description = "标签")
    private String tag;
    @Schema(description = "图片")
    private String img;
}
