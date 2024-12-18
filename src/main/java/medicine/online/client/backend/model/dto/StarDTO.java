package medicine.online.client.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 添加/删除收藏请求参数封装类
 */
@Data
@Schema(description = "添加/删除收藏")
public class StarDTO {
    @Schema(description = "用户ID")
    private Integer userId;
    @Schema(description = "收藏ID")
    private Integer contentId;
    @Schema(description = "收藏类型（0专题，1资讯，2视频课程）")
    private Integer type;
}
