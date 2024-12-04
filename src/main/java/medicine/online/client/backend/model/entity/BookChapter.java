package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookChapter
 */
@Data
@TableName("t_book_chapter")
public class BookChapter {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private Integer bookId;
    private String title;
    private Integer startPage;
    private Integer num;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
