package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.mapper.CollectionMapper;
import medicine.online.client.backend.model.entity.Collection;
import medicine.online.client.backend.service.CollectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author WangL
 */
@Slf4j
@Service
@AllArgsConstructor
public class CollectionServiceImpl implements CollectionService {

    private final CollectionMapper collectionMapper;

    @Override
    public boolean deleteCollection(Integer contentId, Integer type) {
        Integer userId = getCurrentUserId();
        // 假设获取当前用户 ID 的方法

        // 更新 delete_flag 为 1（标记为已删除）
        UpdateWrapper<Collection> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", userId)
                .eq("content_id", contentId)
                .eq("type", type)
                .eq("delete_flag", 0)
                // 确保未删除
                .set("delete_flag", 1);
        // 将 delete_flag 更新为 1
        // 执行更新操作，返回受影响的行数
        int result = collectionMapper.update(null, updateWrapper);

        // 确保该收藏当前未删除

        // 执行更新操作，返回受影响的行数


        if (result > 0) {
            log.info("删除收藏成功，contentId: {}, type: {}", contentId, type);
        } else {
            log.error("删除收藏失败，contentId: {}, type: {}", contentId, type);
        }

        return result > 0;
        // 如果更新成功，返回 true
    }

    @Override
    public boolean addCollection(Integer contentId, Integer type) {
        Integer userId = getCurrentUserId();
        // 获取当前用户 ID（你可以根据实际情况调整）

        // 创建 Collection 实体对象
        Collection collection = new Collection();
        collection.setUserId(userId);
        collection.setContentId(contentId);
        collection.setType(type);
        collection.setDeleteFlag(0);
        // 默认未删除
        collection.setCreateTime(LocalDateTime.now());
        // 设置当前时间
        collection.setUpdateTime(LocalDateTime.now());

        // 插入数据
        int result = collectionMapper.insert(collection);

        // 判断插入是否成功
        if (result > 0) {
            log.info("添加收藏成功，contentId: {}, type: {}", contentId, type);
        } else {
            log.error("添加收藏失败，contentId: {}, type: {}", contentId, type);
        }

        return result > 0;
        // 如果插入成功，返回 true
    }

    private Integer getCurrentUserId() {
        // 返回当前用户ID，待实现
        return 1;
        // 目前先默认用户id为1
    }
}