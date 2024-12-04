package medicine.online.client.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.model.entity.Course;
import medicine.online.client.backend.model.query.Query;
import medicine.online.client.backend.model.vo.CourseVO;

import java.util.List;

public interface CourseService extends IService<Course> {

    // 获取分页上新视频列表方法
    PageResult<CourseVO> getsPageCourseList(Query query);



}
