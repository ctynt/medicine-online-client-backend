package medicine.online.client.backend.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.ibatis.javassist.SerialVersionUID;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author: minder
 * @createTime: 2024/12/13 17:14
 * @description:
 **/
@Data
@Schema(description = "考核子项列表")
public class QuizItemVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 12341243534L;
    @Schema(description = "子项id")
    private Integer pkId;
    @Schema(description = "父项考核id")
    private Integer examineId;
    @Schema(description = "子项名")
    private String name;
    @Schema(description = "描述")
    private String brief;
    @Schema(description = "类型")
    private Integer type;
}
