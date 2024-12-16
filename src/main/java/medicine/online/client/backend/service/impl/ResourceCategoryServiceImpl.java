package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.constant.Constant;
import medicine.online.client.backend.convert.ResourceCategoryConvert;
import medicine.online.client.backend.mapper.ResourceCategoryMapper;
import medicine.online.client.backend.model.entity.ResourceCategory;
import medicine.online.client.backend.model.vo.ResourceCategoryVO;
import medicine.online.client.backend.service.ResourceCategoryService;
import medicine.online.client.backend.utils.TreeUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ctynt
 * @Date 2024/12/4
 * @Description ResourceCategoryServiceImpl
 */
@Slf4j
@Service
@AllArgsConstructor
public class ResourceCategoryServiceImpl extends ServiceImpl<ResourceCategoryMapper, ResourceCategory> implements ResourceCategoryService {

    @Override
    public List<ResourceCategoryVO> getResourceCategoryTree(Integer parentId) {
        // 获取所有的分类数据
        List<ResourceCategoryVO> allCategories = ResourceCategoryConvert.INSTANCE.convertToList(baseMapper.selectList(null));

        // 按 sort 字段进行排序
        allCategories.sort(Comparator.comparingInt(ResourceCategoryVO::getSort)); // 以 sort 字段升序排序

        // 获取父节点为指定 parentId 的所有节点
        List<ResourceCategoryVO> rootCategories = allCategories.stream()
                .filter(category -> category.getParentId().equals(parentId)) // 根据 parentId 查询当前节点
                .collect(Collectors.toList());

        // 遍历当前父节点，递归获取每个节点的子节点
        for (ResourceCategoryVO rootCategory : rootCategories) {
            buildCategoryTree(rootCategory, allCategories);
        }

        return rootCategories;
    }

    // 递归构建树形结构
    private void buildCategoryTree(ResourceCategoryVO parentCategory, List<ResourceCategoryVO> allCategories) {
        List<ResourceCategoryVO> children = allCategories.stream()
                .filter(category -> category.getParentId().equals(parentCategory.getPkId())) // 根据 parentId 获取子节点
                .collect(Collectors.toList());

        if (!children.isEmpty()) {
            // 设置子节点
            parentCategory.setChildren(children);
            // 递归处理子节点的子节点
            for (ResourceCategoryVO child : children) {
                buildCategoryTree(child, allCategories);
            }
        }

        // 对每个父节点的子节点进行排序
        if (parentCategory.getChildren() != null && !parentCategory.getChildren().isEmpty()) {
            parentCategory.getChildren().sort(Comparator.comparingInt(ResourceCategoryVO::getSort));
        }
    }
}
