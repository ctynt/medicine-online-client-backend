package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.BookChapter;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookChapterMapper
 */

public interface BookChapterMapper extends BaseMapper<BookChapter> {
    default List<BookChapter> getChapterList(Integer bookId){
        return this.selectList(new LambdaQueryWrapper<BookChapter>().eq(BookChapter::getBookId,bookId));
    }
}
