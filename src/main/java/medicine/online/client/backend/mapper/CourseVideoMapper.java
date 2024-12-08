package medicine.online.client.backend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.CourseVideo;
import medicine.online.client.backend.model.vo.CourseVideoVO;

public interface CourseVideoMapper extends BaseMapper<CourseVideo> {

    //    获取资讯列表详情详情方法
    CourseVideoVO getCourseVideoDetail(Integer id);
}