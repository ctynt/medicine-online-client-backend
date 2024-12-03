package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.Book;
import medicine.online.client.backend.model.vo.BookVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookConvert
 */
@Mapper
public interface BookConvert {
    BookConvert INSTANCE = Mappers.getMapper(BookConvert.class);

    List<BookVO> convert(List<Book> books);

}
