package medicine.online.client.backend.service.impl;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.mapper.CourseMapper;
import medicine.online.client.backend.model.entity.Course;
import medicine.online.client.backend.model.query.Query;
import medicine.online.client.backend.model.vo.CourseVO;
import medicine.online.client.backend.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CourseServieImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    // 上新视频
    @Override
    public PageResult<CourseVO> getsPageCourseList(Query query) {
        Page<CourseVO> page = new Page<>(query.getPage(), query.getLimit());
        List<CourseVO> list = baseMapper.getsPageCourseList(page, query);
        return new PageResult<>(list, page.getTotal());
    }


}
