package medicine.online.client.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.CourseVideo;
import medicine.online.client.backend.model.vo.CourseVideoVO;

public interface CourseVideoService extends IService<CourseVideo> {

    // 视频列表详情方法
    CourseVideoVO getCourseVideoDetail(Integer id);
}
