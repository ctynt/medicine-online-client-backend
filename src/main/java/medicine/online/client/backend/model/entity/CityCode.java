package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/11/27
 * @Description City
 */
@Data
@TableName("t_city_code")
public class CityCode {

    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private Integer code;
    private String name;
    private Integer parentCode;
    private Integer level;
}
