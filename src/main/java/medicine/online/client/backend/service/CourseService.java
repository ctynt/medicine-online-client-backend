package medicine.online.client.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.model.entity.Course;
import medicine.online.client.backend.model.query.Query;
import medicine.online.client.backend.model.vo.CourseVO;
import medicine.online.client.backend.model.vo.PodcastVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseService extends IService<Course> {

    // 获取分页上新视频列表方法
    PageResult<CourseVO> getsPageCourseList(Query query);

    // 分页专题分页视频列表方法
    PageResult<CourseVO> getPageCourseList(Query query, Integer subjectId, Integer categoryId);

    // 分页专题分页视频集列表方法
    PageResult<CourseVO> getPageVideosList(Query query, Integer videosId);

    // 知识库查询
    List<CourseVO> getCourseList(Integer categoryId);

    // 专题视频列表
    List<CourseVO> ztCourse(@Param("subjectId") Integer subjectId);
}
