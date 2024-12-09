package medicine.online.client.backend.model.query;

import lombok.Data;

/**
 * 收藏列表查询参数封装类
 * @author WangL
 */
@Data
public class StarQuery {
    private Integer pageNum;
    // 当前页
    private Integer pageSize;
    // 每页条数
    private Integer userId;
    // 用户 ID
    private Integer type;
    // 收藏类型（专题/资讯/视频课程）
    private Integer deleteFlag;
    // 删除标志（0表示未删除，1表示已删除）
}
