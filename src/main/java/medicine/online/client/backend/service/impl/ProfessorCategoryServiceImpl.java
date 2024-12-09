package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.mapper.ProfessorCategoryMapper;
import medicine.online.client.backend.model.vo.ProfessorCategoryVO;
import medicine.online.client.backend.model.entity.ProfessorCategory;
import medicine.online.client.backend.service.ProfessorCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@Slf4j
@Service
@AllArgsConstructor
public class ProfessorCategoryServiceImpl extends ServiceImpl<ProfessorCategoryMapper, ProfessorCategory> implements ProfessorCategoryService {
    private final ProfessorCategoryMapper professorCategoryMapper;

    @Override
    public List<ProfessorCategoryVO> listCategoryForCustomer() {
        // 确保初始化
        List<ProfessorCategoryVO> categoryVOList = new ArrayList<>();
        recursivelyFindCategories(categoryVOList, 0);
        return categoryVOList;
    }

    private void recursivelyFindCategories(List<ProfessorCategoryVO> categoryVOList, Integer parentId) {
        if (categoryVOList == null) {
            log.error("categoryVOList在recursivelyFindCategories方法中为空");
            // 避免空指针异常
            return;
        }

        // 递归获取所有子类别，并组合成为一个“目录树”
        QueryWrapper<ProfessorCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        List<ProfessorCategory> categoryList = professorCategoryMapper.selectList(queryWrapper);

        if (!CollectionUtils.isEmpty(categoryList)) {
            for (ProfessorCategory category : categoryList) {
                ProfessorCategoryVO categoryVO = new ProfessorCategoryVO();
                // 假设我们有一个方法来复制属性
                 BeanUtils.copyProperties(category, categoryVO);
                // 确保导入了正确的BeanUtils
                categoryVO.setPkId(category.getPkId());
                categoryVO.setName(category.getName());
                categoryVO.setCover(category.getCover());
                // 初始化子列表
                categoryVO.setChildCategory(new ArrayList<>());

                categoryVOList.add(categoryVO);
                recursivelyFindCategories(categoryVO.getChildCategory(), category.getPkId());
            }
        }
    }
}