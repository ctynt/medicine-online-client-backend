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
    public List<ResourceCategoryVO> getResourceCategoryTree() {
        // 获取树形结构数据，返回的是 ResourceCategoryVO 列表
        List<ResourceCategoryVO> treeList = TreeUtils.build(ResourceCategoryConvert.INSTANCE.convertToList(baseMapper.selectList(null)), Constant.ROOT);

        // 根节点，直接加入列表
        List<ResourceCategoryVO> resultList = new ArrayList<>();
        ResourceCategoryVO rootCategory = new ResourceCategoryVO();
        rootCategory.setPkId(0);
        rootCategory.setTitle("根节点");
        resultList.add(rootCategory);

        // 遍历树形结构，递归处理子节点，进行排序并添加缩进
        for (ResourceCategoryVO menu : treeList) {
            addNodeWithIndent(menu, resultList, 1);
        }

        return resultList;
    }

    /**
     * 递归地为树节点添加缩进并加入到结果列表中
     * @param node 当前节点
     * @param resultList 结果列表
     * @param level 当前层级
     */
    private void addNodeWithIndent(ResourceCategoryVO node, List<ResourceCategoryVO> resultList, int level) {
        // 为当前节点设置缩进
        node.setTitle("      ".repeat(level) + node.getTitle());
        resultList.add(node);

        // 如果当前节点有子节点，先排序然后递归处理子节点
        if (node.getChildren() != null && !node.getChildren().isEmpty()) {
            // 按照 sort 字段进行排序
            node.getChildren().sort(Comparator.comparingInt(ResourceCategoryVO::getSort));

            // 递归处理下一层级的子节点
            for (ResourceCategoryVO child : node.getChildren()) {
                addNodeWithIndent(child, resultList, level + 1); // 递归处理下一层级
            }
        }
    }


}

