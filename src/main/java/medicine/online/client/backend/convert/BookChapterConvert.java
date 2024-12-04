package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.BookChapter;
import medicine.online.client.backend.model.vo.BookChapterVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookChapterConvert
 */
@Mapper
public interface BookChapterConvert {
    BookChapterConvert INSTANCE = Mappers.getMapper(BookChapterConvert.class);
    List<BookChapterVO> convert(List<BookChapter> list);
}
