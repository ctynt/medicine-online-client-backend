package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletRequest;
import medicine.online.client.backend.common.cache.RequestContext;
import medicine.online.client.backend.model.dto.StarDTO;
import medicine.online.client.backend.model.query.StarQuery;
import medicine.online.client.backend.model.vo.StarVO;
import medicine.online.client.backend.model.vo.UserInfoVO;

/**
 * @author WangL
 * @description 收藏业务逻辑层接口
 */
public interface StarService {

    /**
     * 查询用户的收藏列表（分页）
     *
     * @param collectionQuery 查询条件
     * @return 分页的收藏列表
     */
    Page<StarVO> getCollectionList(Integer userId, StarQuery collectionQuery);

    /**
     * 添加收藏
     *
     * @param starDTO 收藏信息
     * @return 是否成功
     */
    boolean addCollection(Integer userId, StarDTO starDTO);

    /**
     * 删除收藏
     *
     * @param starDTO 收藏信息
     * @return 是否成功
     */
    boolean deleteCollection(Integer userId, StarDTO starDTO);

}
