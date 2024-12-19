package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: minder
 * @createTime: 2024/12/16 16:17
 * @description:
 **/
@Data
@TableName("t_quiz_paper_detail")
public class PaperDetail {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private Integer contentId;
    private Integer questionId;
}
