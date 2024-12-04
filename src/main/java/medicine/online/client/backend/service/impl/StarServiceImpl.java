package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.mapper.NewsMapper;
import medicine.online.client.backend.mapper.StarMapper;
import medicine.online.client.backend.model.entity.News;
import medicine.online.client.backend.model.entity.Star;
import medicine.online.client.backend.model.vo.StarVO;
import medicine.online.client.backend.service.StarService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WangL
 */
@Slf4j
@Service
@AllArgsConstructor
public class StarServiceImpl implements StarService {

    private final StarMapper starMapper;
    private final NewsMapper newsMapper;

    @Override
    public boolean deleteCollection(Integer contentId, Integer type) {
        Integer userId = getCurrentUserId();
        // 假设获取当前用户 ID 的方法

        // 更新 delete_flag 为 1（标记为已删除）
        UpdateWrapper<Star> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", userId)
                .eq("content_id", contentId)
                .eq("type", type)
                .eq("delete_flag", 0)
                // 确保未删除
                .set("delete_flag", 1);
        // 将 delete_flag 更新为 1
        // 执行更新操作，返回受影响的行数
        int result = starMapper.update(null, updateWrapper);

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

        // 创建 Star 实体对象
        Star star = new Star();
        star.setUserId(userId);
        star.setContentId(contentId);
        star.setType(type);
        star.setDeleteFlag(0);
        // 默认未删除
        star.setCreateTime(LocalDateTime.now());
        // 设置当前时间
        star.setUpdateTime(LocalDateTime.now());

        // 插入数据
        int result = starMapper.insert(star);

        // 判断插入是否成功
        if (result > 0) {
            log.info("添加收藏成功，contentId: {}, type: {}", contentId, type);
        } else {
            log.error("添加收藏失败，contentId: {}, type: {}", contentId, type);
        }

        return result > 0;
        // 如果插入成功，返回 true
    }

    @Override
    public Page<StarVO> getCollectionList(Integer pageNum, Integer pageSize) {
        Integer userId = getCurrentUserId();
        // 获取当前用户ID

        // 构建查询条件，查询当前用户的收藏记录，并且 delete_flag = 0（未删除）
        QueryWrapper<Star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                // 确保查询指定用户的收藏
                .eq("delete_flag", 0);
        // 确保查询未删除的收藏记录

        // 创建分页对象
        Page<Star> page = new Page<>(pageNum, pageSize);

        // 查询分页数据
        Page<Star> starPage = starMapper.selectPage(page, queryWrapper);

        // 转换为 VO 对象，并填充相关的资讯信息
        List<StarVO> starVOList = starPage.getRecords().stream().map(star -> {
            StarVO starVO = new StarVO();
            starVO.setPkId(star.getPkId());
            starVO.setContentId(star.getContentId());
            starVO.setType(star.getType());

            // 获取资讯详情
            News news = newsMapper.selectById(star.getContentId());
            // 使用 newsMapper 查询资讯
            if (news != null) {
                starVO.setInfo(news);
            }

            return starVO;
        }).collect(Collectors.toList());

        // 创建并返回分页结果
        Page<StarVO> result = new Page<>();
        result.setRecords(starVOList);
        result.setTotal(starPage.getTotal());
        result.setPages(starPage.getPages());
        result.setCurrent(starPage.getCurrent());
        result.setSize(starPage.getSize());

        return result;
    }


    private Integer getCurrentUserId() {
        // 返回当前用户ID，待实现
        return 357;
        // 目前先默认用户id为1
    }
}