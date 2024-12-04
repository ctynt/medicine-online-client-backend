package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.ResourceCategory;
import medicine.online.client.backend.model.vo.ResourceCategoryVO;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/4
 * @Description ResourceCategoryService
 */

public interface ResourceCategoryService extends IService<ResourceCategory> {
    List<ResourceCategoryVO> getResourceCategoryTree();
}
