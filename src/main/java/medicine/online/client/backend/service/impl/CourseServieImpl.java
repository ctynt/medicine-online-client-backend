package medicine.online.client.backend.service.impl;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.exception.ServerException;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.convert.CourseConvert;
import medicine.online.client.backend.mapper.CourseMapper;
import medicine.online.client.backend.mapper.CourseVideoMapper;
import medicine.online.client.backend.mapper.ResourceCategoryMapper;
import medicine.online.client.backend.model.entity.Course;
import medicine.online.client.backend.model.entity.CourseVideo;
import medicine.online.client.backend.model.entity.ResourceCategory;
import medicine.online.client.backend.model.query.Query;
import medicine.online.client.backend.model.vo.CourseVO;
import medicine.online.client.backend.model.vo.CourseVideoVO;
import medicine.online.client.backend.model.vo.PodcastVO;
import medicine.online.client.backend.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CourseServieImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    private final CourseVideoMapper courseVideoMapper;
    private final String front = "https://medicineonline.oss-cn-hangzhou.aliyuncs.com/";

    @Override
    public PageResult<CourseVO> getsPageCourseList(Query query) {
        Page<CourseVO> page = new Page<>(query.getPage(), query.getLimit());
        List<CourseVO> list = baseMapper.getsPageCourseList(page, query);
        // 处理 cover 和 url 字段
        for (CourseVO courseVO : list) {
            // 处理 cover 图片前缀
            String cover = courseVO.getCover();
            if (cover != null && !cover.startsWith("https://")) {
                courseVO.setCover(front + cover);
            }

            // 处理 url 前缀
            String url = courseVO.getUrl();
            if (url != null && !url.startsWith("https://")) {
                courseVO.setUrl(front + url);
            }
        }
        return new PageResult<>(list, page.getTotal());
    }

    // 专题视频
    @Override
    public PageResult<CourseVO> getPageCourseList(Query query, Integer subjectId, Integer categoryId) {
        Page<CourseVO> page = new Page<>(query.getPage(), query.getLimit());
        List<CourseVO> list = baseMapper.getPageCourseList(page, query, subjectId, categoryId);
        // 处理 cover 和 url 字段
        for (CourseVO courseVO : list) {
            // 处理 cover 图片前缀
            String cover = courseVO.getCover();
            if (cover != null && !cover.startsWith("https://")) {
                courseVO.setCover(front + cover);
            }

            // 处理 url 前缀
            String url = courseVO.getUrl();
            if (url != null && !url.startsWith("https://")) {
                courseVO.setUrl(front + url);
            }
        }
        return new PageResult<>(list, page.getTotal());
    }

    // 专题视频集
    @Override
    public PageResult<CourseVO> getPageVideosList(Query query, Integer videosId) {
        Page<CourseVO> page = new Page<>(query.getPage(), query.getLimit());
        List<CourseVO> list = baseMapper.getPageVideosList(page, query, videosId);
        // 处理 cover 和 url 字段
        for (CourseVO courseVO : list) {
            // 处理 cover 图片前缀
            String cover = courseVO.getCover();
            if (cover != null && !cover.startsWith("https://")) {
                courseVO.setCover(front + cover);
            }

            // 处理 url 前缀
            String url = courseVO.getUrl();
            if (url != null && !url.startsWith("https://")) {
                courseVO.setUrl(front + url);
            }
        }
        return new PageResult<>(list, page.getTotal());
    }


    @Override
    public List<CourseVO> getCourseList(Integer categoryId) {
        List<Course> courses = baseMapper.selectListByCategoryId(categoryId);
        if (courses == null || courses.isEmpty()) {
            return new ArrayList<>(); // 返回空的课程列表
        }
        List<CourseVO> courseVOList = CourseConvert.INSTANCE.convert(courses);
        for (CourseVO courseVO : courseVOList) {
            CourseVideo courseVideo = courseVideoMapper.getByCourseId(courseVO.getPkId());
            if (courseVideo != null) {
                String url = courseVideo.getUrl();
                if (url != null && !url.startsWith("https://")) {
                    url = front + url; // 如果没有 https 前缀，则添加 https
                }
                courseVO.setUrl(url);
            } else {
                courseVO.setUrl(null);
            }
            String cover = courseVO.getCover();
            if (cover != null && !cover.startsWith("https://")) {
                cover = front + cover; // 如果没有 https 前缀，则添加 https
            }
            courseVO.setCover(cover);
        }

        return courseVOList;
    }

    @Override
    public List<CourseVO> ztCourse(Integer subjectId) {
        // 获取视频详情
        List<CourseVO> list = baseMapper.ztCourse(subjectId);
        // 处理 cover 和 url 字段
        for (CourseVO courseVO : list) {
            // 处理 cover 图片前缀
            String cover = courseVO.getCover();
            if (cover != null && !cover.startsWith("https://")) {
                courseVO.setCover(front + cover);
            }

            // 处理 url 前缀
            String url = courseVO.getUrl();
            if (url != null && !url.startsWith("https://")) {
                courseVO.setUrl(front + url);
            }
        }
        return list;
    }
}
