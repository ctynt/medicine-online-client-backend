package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.BookCategory;
import medicine.online.client.backend.model.vo.BookCategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookCategoryConvert
 */
@Mapper
public interface BookCategoryConvert {
    BookCategoryConvert INSTANCE = Mappers.getMapper(BookCategoryConvert.class);

    List<BookCategoryVO> convert(List<BookCategory> bookCategories);
}
