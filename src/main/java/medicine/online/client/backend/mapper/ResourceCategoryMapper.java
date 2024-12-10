package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.ResourceCategory;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description ResourceCategoryMapper
 */

public interface ResourceCategoryMapper extends BaseMapper<ResourceCategory> {
    default ResourceCategory getResourceCategory(String categoryName) {
        return this.selectOne(new LambdaQueryWrapper<ResourceCategory>().eq(ResourceCategory::getTitle, categoryName));
    }
}
