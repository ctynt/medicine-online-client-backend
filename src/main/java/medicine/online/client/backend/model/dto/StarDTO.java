package medicine.online.client.backend.model.dto;

import lombok.Data;

/**
 * 添加/删除收藏请求参数封装类
 */
@Data
public class StarDTO {
    private Integer contentId;
    // 关联内容ID
    private Integer type;
    // 收藏类型（0专题，1资讯，2视频课程）
}
