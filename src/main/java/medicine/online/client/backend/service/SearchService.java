package medicine.online.client.backend.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.client.backend.model.vo.CourseVO;
import medicine.online.client.backend.model.vo.NewsVO;
import medicine.online.client.backend.model.vo.PodcastVO;
import medicine.online.client.backend.model.vo.SubjectVO;

public interface SearchService {
    Page<SubjectVO> getSubjectByTitleLike(String title, Page<SubjectVO> page);
    Page<NewsVO> getNewsByTitleLike(String title, Page<NewsVO> page);
    Page<CourseVO> getCourseByTitleLike(String title, Page<CourseVO> page);
    Page<PodcastVO> getPodcastByTitleLike(String title, Page<PodcastVO> page);

    // 新增方法用于判断专题表pk_id是否存在于t_index_content表
    boolean isSubjectPkIdExist(Integer pkId);

    boolean isNewsPkIdExist(Integer pkId);

    boolean isCoursePkIdExist(Integer pkId);

    boolean isPodcastPkIdExist(Integer pkId);

}
