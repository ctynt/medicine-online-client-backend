package medicine.online.client.backend.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户修改dto")
public class UserEditDTO {
    @Schema(description = "主键")
    private Integer pkId;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "口号")
    private String slogan;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "医院")
    private Integer hospital;

    @Schema(description = "学位")
    private String licence;
}