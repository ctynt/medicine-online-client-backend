package medicine.online.client.backend.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.mapper.NewsMapper;
import medicine.online.client.backend.model.entity.News;
import medicine.online.client.backend.model.query.NewsQuery;
import medicine.online.client.backend.model.vo.NewsVO;
import medicine.online.client.backend.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Override
    public List<NewsVO> indexPageNews() {
        return baseMapper.indexPageNews();
    }

    @Override
    public PageResult<NewsVO> getNewsList(NewsQuery query) {
        Page<NewsVO> page = new Page<>(query.getPage(), query.getLimit());
        List<NewsVO> list = baseMapper.getNewsPage(page, query);
        return new PageResult<>(list, page.getTotal());
    }

    @Override
    public NewsVO getNewsDetail(Integer id) {
        return baseMapper.getNewsDetail(id);
    }
}
