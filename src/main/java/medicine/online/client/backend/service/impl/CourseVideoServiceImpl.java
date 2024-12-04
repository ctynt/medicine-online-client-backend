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
        return baseMapper.getCourseVideoDetail(id);
    }
}
