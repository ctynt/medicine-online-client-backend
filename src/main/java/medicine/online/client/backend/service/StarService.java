package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.dto.StarDTO;
import medicine.online.client.backend.model.entity.Star;
import medicine.online.client.backend.model.query.StarQuery;
import medicine.online.client.backend.model.vo.StarVO;

/**
 * @author WangL
 * @description 收藏业务逻辑层接口
 */
public interface StarService extends IService<Star> {

    /**
     * 查询用户的收藏列表（分页）
     */
    Page<StarVO> getCollectionList(Integer userId, StarQuery collectionQuery);

    /**
     * 添加收藏
     */
    void addCollection(Integer userId, StarDTO starDTO);

    /**
     * 删除收藏
     */
    void deleteCollection(Integer userId, StarDTO starDTO);

}
