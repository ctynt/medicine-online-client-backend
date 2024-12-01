package medicine.online.client.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.model.entity.News;
import medicine.online.client.backend.model.query.NewsQuery;
import medicine.online.client.backend.model.vo.NewsVO;

import java.util.List;

public interface NewsService extends IService<News> {

    // 定义获取⾸⻚资讯列表⽅法
    List<NewsVO> indexPageNews();

    // 分⻚查询资讯列表⽅法
    PageResult<NewsVO> getNewsList(NewsQuery query);

    // 资讯列表详情方法
    NewsVO getNewsDetail(Integer id);
}
