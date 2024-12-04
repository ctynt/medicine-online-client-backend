package medicine.online.client.backend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.Category;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    // 自定义方法，根据parentId查询Category列表
    List<Category> selectCategoriesByParentId(Long parentId);
}
