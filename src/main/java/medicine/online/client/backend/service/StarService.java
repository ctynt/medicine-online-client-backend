package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.client.backend.model.vo.StarVO;

/**
 * @author WangL
 */
public interface StarService {

    /**
     * 删除收藏
     */
    boolean deleteCollection(Integer contentId, Integer type);

    /**
     * 添加收藏
     */
    boolean addCollection(Integer contentId, Integer type);

    /**
     * 查询用户收藏列表（分页）
     */
    Page<StarVO> getCollectionList(Integer pageNum, Integer pageSize);
}