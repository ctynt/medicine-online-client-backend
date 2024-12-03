package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description Book
 */

@Data
@TableName("t_book")
public class Book {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;
    private Integer categoryId;
    private String title;
    private String cover;
    private String titleEn;
    private Integer state;
    private Integer managerId;
    private String sort;
    private Integer totalPage;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    private Integer browseNum;
}