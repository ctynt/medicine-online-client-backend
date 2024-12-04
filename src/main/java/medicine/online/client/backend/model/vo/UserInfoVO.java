package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Schema(description = "用户信息")
public class UserInfoVO implements Serializable {
    @Serial
    private static final long serialVersionUID = -45095106764580159L;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "口号")
    private String slogan;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "文化程度")
    private String licence;

    @Schema(description = "职业类别")
    private String profession;

    @Schema(description = "姓名")
    private String name;

    @Schema(description = "性别")
    private Integer sex;

    @Schema(description = "年龄")
    private Integer age;

    @Schema(description = "学员表id")
    private Integer pkId;

    @Schema(description = "省")
    private String province;

    @Schema(description = "市")
    private String city;

    @Schema(description = "区")
    private String area;

    @Schema(description = "医院")
    private String hospital;

    @Schema(description = "总学分=学时")
    private String totalScore;

    @Schema(description = "有无消息")
    private String message;

}