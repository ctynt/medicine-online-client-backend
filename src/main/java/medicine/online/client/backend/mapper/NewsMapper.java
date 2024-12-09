package medicine.online.client.backend.mapper;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import medicine.online.client.backend.model.entity.News;
import medicine.online.client.backend.model.query.NewsQuery;
import medicine.online.client.backend.model.vo.NewsVO;

import java.util.List;


//@Repository
public interface NewsMapper extends BaseMapper<News> {

    // 获取⾸⻚(置顶)资讯列表⽅法
    List<NewsVO> indexPageNews();

    // 分⻚查询资讯列表⽅法
    List<NewsVO> getNewsPage(Page<NewsVO> page, @Param("query") NewsQuery query);

    // 获取资讯列表详情详情方法
    NewsVO getNewsDetail(Integer id);

    // 根据title模糊查询
    Page<NewsVO> getNewsByTitleLike(@Param("title") String title, Page<NewsVO> page, QueryWrapper<NewsVO> queryWrapper);

    // 新增方法用于判断pk_id是否存在于t_index_content表中
    boolean isNewsPkIdExist(Integer pkId);
}
