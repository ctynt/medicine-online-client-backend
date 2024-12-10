package medicine.online.client.backend.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.mapper.CourseVideoMapper;
import medicine.online.client.backend.model.entity.CourseVideo;
import medicine.online.client.backend.model.vo.CourseVideoVO;
import medicine.online.client.backend.service.CourseVideoService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CourseVideoServiceImpl extends ServiceImpl<CourseVideoMapper, CourseVideo> implements CourseVideoService {

    @Override
    public CourseVideoVO getCourseVideoDetail(Integer id) {
        // 获取视频详情
        CourseVideoVO courseVideoVO = baseMapper.getCourseVideoDetail(id);

        // 判断url字段，如果为空或不包含https前缀，补充https://
        if (courseVideoVO != null && courseVideoVO.getUrl() != null) {
            String url = courseVideoVO.getUrl();
            if (!url.startsWith("https://")) {
                courseVideoVO.setUrl("https://medicineonline.oss-cn-hangzhou.aliyuncs.com/" + url);  // 自动加上https://前缀
            }
        }

        return courseVideoVO;
    }

}
