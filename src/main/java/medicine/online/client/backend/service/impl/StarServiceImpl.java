package medicine.online.client.backend.service.impl;

import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.cache.RequestContext;
import medicine.online.client.backend.mapper.NewsMapper;
import medicine.online.client.backend.mapper.StarMapper;
import medicine.online.client.backend.model.dto.StarDTO;
import medicine.online.client.backend.model.entity.News;
import medicine.online.client.backend.model.entity.Star;
import medicine.online.client.backend.model.query.StarQuery;
import medicine.online.client.backend.model.vo.StarVO;
import medicine.online.client.backend.service.StarService;
import medicine.online.client.backend.utils.JwtUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author WangL
 * @description 收藏业务逻辑实现类
 */
@Slf4j
@Service
@AllArgsConstructor
public class StarServiceImpl implements StarService {

    private final StarMapper starMapper;
    private final NewsMapper newsMapper;

    /**
     * 查询用户的收藏列表（分页）
     */
    @Override
    public Page<StarVO> getCollectionList(Integer userId, StarQuery collectionQuery) {
//        Integer userId = RequestContext.getUserId();

        // 获取用户ID
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        Integer pageNum = collectionQuery.getPageNum();
        // 当前页
        Integer pageSize = collectionQuery.getPageSize();
        // 每页条数

        // 创建分页对象
        Page<Star> page = new Page<>(pageNum, pageSize);

        // 构建查询条件：查询指定用户的收藏记录，删除标记为0（未删除）
        QueryWrapper<Star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId)
                .eq("delete_flag", 0);
        // 只查询未删除的收藏记录

        // 执行分页查询
        Page<Star> starPage = starMapper.selectPage(page, queryWrapper);

        // 转换为 VO 对象并填充相关内容信息（这里以资讯为例）
        List<StarVO> starVOList = starPage.getRecords().stream().map(star -> {
            StarVO starVO = new StarVO();
            starVO.setPkId(star.getPkId());
            starVO.setContentId(star.getContentId());
            starVO.setType(star.getType());

            // 获取资讯详情（这里假设我们是收藏了资讯，可以根据实际情况修改）
            News news = newsMapper.selectById(star.getContentId());
            if (news != null) {
                starVO.setInfo(news);
            }

            return starVO;
        }).collect(Collectors.toList());

        // 返回分页数据
        Page<StarVO> result = new Page<>();
        result.setRecords(starVOList);
        result.setTotal(starPage.getTotal());
        result.setPages(starPage.getPages());
        result.setCurrent(starPage.getCurrent());
        result.setSize(starPage.getSize());

        return result;
    }

    /**
     * 添加收藏
     */
    @Override
    public boolean addCollection(Integer userId,StarDTO starDTO) {
//        Integer userId = RequestContext.getUserId();
        // 获取当前用户ID

        if (userId == null) {
            log.error("User ID is null when adding collection");
            return false;
        }

        // 创建收藏记录
        Star star = new Star();
        star.setUserId(userId);
        star.setContentId(starDTO.getContentId());
        star.setType(starDTO.getType());
        star.setDeleteFlag(0);
        // 默认未删除
        star.setCreateTime(LocalDateTime.now());
        star.setUpdateTime(LocalDateTime.now());

        // 插入收藏记录
        int result = starMapper.insert(star);

        // 返回结果
        return result > 0;
    }

    /**
     * 删除收藏
     */
    @Override
    public boolean deleteCollection(Integer userId, StarDTO starDTO) {
//        Integer userId = RequestContext.getUserId();
     // 获取当前用户ID

        if (userId == null) {
            log.error("User ID is null when deleting collection");
            return false;
        }

        // 更新收藏记录的删除标志为 1（已删除）
        UpdateWrapper<Star> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", userId)
                .eq("content_id", starDTO.getContentId())
                .eq("type", starDTO.getType())
                .eq("delete_flag", 0)
                // 只更新未删除的记录
                .set("delete_flag", 1);
        // 更新为已删除

        // 执行更新操作
        int result = starMapper.update(null, updateWrapper);

        return result > 0;
    }

    /**
     * 获取当前用户ID（模拟获取用户ID，实际可根据用户会话或 JWT 获取）
     */
//    private Integer getCurrentUserId() {
//        try {
//            return RequestContext.getUserId();
//        } catch (IllegalArgumentException e) {
//            log.error("Failed to get user ID from context: {}", e.getMessage());
//            return null;
//        }
//    }
}



