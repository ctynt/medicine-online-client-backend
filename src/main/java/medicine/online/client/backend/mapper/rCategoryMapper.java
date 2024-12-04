package medicine.online.client.backend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.rCategory;

import java.util.List;

public interface rCategoryMapper extends BaseMapper<rCategory> {

    // 自定义方法，根据parentId查询Category列表
    List<rCategory> selectrCategoriesByParentId(Long parentId);
}
