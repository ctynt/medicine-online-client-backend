package medicine.online.client.backend.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.client.backend.model.entity.Course;
import medicine.online.client.backend.model.query.NewsQuery;
import medicine.online.client.backend.model.query.Query;
import medicine.online.client.backend.model.vo.CourseVO;
import medicine.online.client.backend.model.vo.NewsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper extends BaseMapper<Course> {

    // 获取分页上新视频列表方法
    List<CourseVO> getsPageCourseList(Page<CourseVO> page, @Param("query") Query query);

    // 获取分页专题分类列表方法
    List<CourseVO> getPageCourseList(Page<CourseVO> page, @Param("query") Query query, Integer categoryId);

    // 模糊查询
    Page<CourseVO> getCourseByTitleLike(@Param("title") String title, Page<CourseVO> page, QueryWrapper<CourseVO> queryWrapper);

    // 新增方法用于判断pk_id是否存在于t_index_content表中
    boolean isCoursePkIdExist(Integer pkId);


}
