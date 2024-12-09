package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.Category;
import medicine.online.client.backend.model.vo.CategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface CategoryConvert {
    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);
    List<CategoryVO> convert(List<Category> list);
}