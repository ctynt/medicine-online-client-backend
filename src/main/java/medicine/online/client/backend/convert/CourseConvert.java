package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.Course;
import medicine.online.client.backend.model.vo.CourseVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/9
 * @Description CourseConvert
 */
@Mapper
public interface CourseConvert {
    CourseConvert INSTANCE = Mappers.getMapper(CourseConvert.class);
    List<CourseVO> convert(List<Course> courses) ;

}
