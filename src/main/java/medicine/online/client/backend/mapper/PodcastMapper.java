package medicine.online.client.backend.mapper;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.client.backend.model.entity.Podcast;
import medicine.online.client.backend.model.vo.PodcastVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PodcastMapper extends BaseMapper<Podcast> {

    // 获取音频列表方法
    List<PodcastVO> ztPodcast(@Param("subjectId") Integer subjectId);

    // 根据标题模糊查询
    Page<PodcastVO> getPodcastByTitleLike(@Param("title") String title, Page<PodcastVO> page, QueryWrapper<PodcastVO> queryWrapper);

    // 新增方法用于判断pk_id是否存在于t_index_content表中
    boolean isPodcastPkIdExist(Integer pkId);

    default List<Podcast> selectListByCategoryId(Integer categoryId) {
        return this.selectList(new LambdaQueryWrapper<Podcast>().eq(Podcast::getCategoryId, categoryId).eq(Podcast::getState,4));
    }
}
