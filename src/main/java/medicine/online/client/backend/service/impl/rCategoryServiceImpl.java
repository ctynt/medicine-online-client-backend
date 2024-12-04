package medicine.online.client.backend.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import medicine.online.client.backend.convert.rCategoryConvert;
import medicine.online.client.backend.mapper.rCategoryMapper;
import medicine.online.client.backend.model.entity.rCategory;
import medicine.online.client.backend.model.vo.rCategoryVO;
import medicine.online.client.backend.service.rCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rCategoryServiceImpl extends ServiceImpl<rCategoryMapper, rCategory> implements rCategoryService {

    @Override
    public List<rCategoryVO> getrCategoryList() {
        LambdaQueryWrapper<rCategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(rCategory::getParentId, 2)
                .orderByAsc(rCategory::getSort);

        return rCategoryConvert.INSTANCE.convert(list(wrapper));
    }

    @Autowired
    private rCategoryMapper rcategoryMapper;

    @Override
    public List<rCategoryVO> getrCategoryListByParentId(Long parentId) {
        LambdaQueryWrapper<rCategory> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(parentId!= null, rCategory::getParentId, parentId)
                .orderByAsc(rCategory::getSort);
        List<rCategory> rcategoryList = rcategoryMapper.selectList(wrapper);
        return rCategoryConvert.INSTANCE.convert(rcategoryList);
    }
}
