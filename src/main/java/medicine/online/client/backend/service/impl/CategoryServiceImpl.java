package medicine.online.client.backend.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import medicine.online.client.backend.convert.CategoryConvert;
import medicine.online.client.backend.mapper.CategoryMapper;
import medicine.online.client.backend.model.entity.Category;
import medicine.online.client.backend.model.vo.CategoryVO;
import medicine.online.client.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public List<CategoryVO> getCategoryList() {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Category::getLevel, 0)
                .orderByAsc(Category::getSort);

        return CategoryConvert.INSTANCE.convert(list(wrapper));
    }

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryVO> getCategoryListByParentId(Long parentId) {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(parentId!= null, Category::getParentId, parentId);
        List<Category> categoryList = categoryMapper.selectList(wrapper);
        return CategoryConvert.INSTANCE.convert(categoryList);
    }


}
