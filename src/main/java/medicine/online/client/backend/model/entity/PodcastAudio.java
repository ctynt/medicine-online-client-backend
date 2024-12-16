package medicine.online.client.backend.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author ctynt
 * @Date 2024/12/11
 * @Description PodcastAudio
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_podcast_audio")
public class PodcastAudio {
    @TableId(value = "pk_id", type = IdType.AUTO)
    private Integer pkId;

    private Integer podcastId;
    private String title;
    private Integer length;
    private Integer sort;
    private String url;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
