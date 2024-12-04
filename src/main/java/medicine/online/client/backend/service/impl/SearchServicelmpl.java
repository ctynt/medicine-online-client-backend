package medicine.online.client.backend.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.client.backend.mapper.CourseMapper;
import medicine.online.client.backend.mapper.NewsMapper;
import medicine.online.client.backend.mapper.PodcastMapper;
import medicine.online.client.backend.mapper.SubjectMapper;
import medicine.online.client.backend.model.vo.CourseVO;
import medicine.online.client.backend.model.vo.NewsVO;
import medicine.online.client.backend.model.vo.PodcastVO;
import medicine.online.client.backend.model.vo.SubjectVO;
import medicine.online.client.backend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServicelmpl implements SearchService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private PodcastMapper podcastMapper;

    @Override
    public Page<SubjectVO> getSubjectByTitleLike(String title, Page<SubjectVO> page) {
        QueryWrapper<SubjectVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", title);
        return subjectMapper.getSubjectByTitleLike(title, page, queryWrapper);
    }

    @Override
    public Page<NewsVO> getNewsByTitleLike(String title, Page<NewsVO> page) {
        QueryWrapper<NewsVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", title);
        return newsMapper.getNewsByTitleLike(title, page, queryWrapper);
    }

    @Override
    public Page<CourseVO> getCourseByTitleLike(String title, Page<CourseVO> page) {
        QueryWrapper<CourseVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", title);
        return courseMapper.getCourseByTitleLike(title, page, queryWrapper);
    }

    @Override
    public Page<PodcastVO> getPodcastByTitleLike(String title, Page<PodcastVO> page) {
        QueryWrapper<PodcastVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title", title);
        return podcastMapper.getPodcastByTitleLike(title, page, queryWrapper);
    }

    @Override
    public boolean isSubjectPkIdExist(Integer pkId) {
        return subjectMapper.isSubjectPkIdExist(pkId);
    }

    @Override
    public boolean isNewsPkIdExist(Integer pkId) {
        return newsMapper.isNewsPkIdExist(pkId);
    }

    @Override
    public boolean isCoursePkIdExist(Integer pkId) {
        return courseMapper.isCoursePkIdExist(pkId);
    }

    @Override
    public boolean isPodcastPkIdExist(Integer pkId) {
        return podcastMapper.isPodcastPkIdExist(pkId);
    }

}
