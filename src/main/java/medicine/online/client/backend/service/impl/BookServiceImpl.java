package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.convert.BookConvert;
import medicine.online.client.backend.mapper.BookCategoryMapper;
import medicine.online.client.backend.mapper.BookMapper;
import medicine.online.client.backend.model.entity.Book;
import medicine.online.client.backend.model.vo.BookVO;
import medicine.online.client.backend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookServiceImpl
 */
@Slf4j
@Service
@AllArgsConstructor
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    private final BookCategoryMapper bookCategoryMapper;
    @Override
    public List<BookVO> getBookListByCategory(String categoryName) {
        List<Book> books = baseMapper.selectListByCategoryId(bookCategoryMapper.getCategoryId(categoryName).getPkId());
        log.info(books.toString());
        return BookConvert.INSTANCE.convert(books);
    }
}
