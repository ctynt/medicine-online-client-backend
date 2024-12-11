package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.convert.BookConvert;
import medicine.online.client.backend.mapper.BookCategoryMapper;
import medicine.online.client.backend.mapper.BookMapper;
import medicine.online.client.backend.model.entity.Book;
import medicine.online.client.backend.model.entity.BookCategory;
import medicine.online.client.backend.model.vo.BookVO;
import medicine.online.client.backend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    private final BookCategoryMapper bookCategoryMapper;
    @Override
    public List<BookVO> getBookListByCategory(String categoryName) {
        BookCategory bookCategory = bookCategoryMapper.getCategoryId(categoryName);
        if (bookCategory == null) {
            return new ArrayList<>();
        }
        List<Book> books = baseMapper.selectListByCategoryId(bookCategory.getPkId());
        List<BookVO> bookVOList = BookConvert.INSTANCE.convert(books);
        for (BookVO bookVO : bookVOList) {
            String cover = bookVO.getCover();
            if (cover != null && !cover.startsWith("https://")) {
                cover = "https://medicineonline.oss-cn-hangzhou.aliyuncs.com/" + cover; // 如果没有 https 前缀，则添加 https
            }
            bookVO.setCover(cover);
        }
        return bookVOList;
    }

    @Override
    public List<BookVO> ztBook(Integer subjectId) {
        List<BookVO> list = baseMapper.ztBook(subjectId);
        for (BookVO bookVO : list) {
            String cover = bookVO.getCover();
            // 如果音频 URL 没有 https 前缀，则添加 https://
            if (cover != null && !cover.isEmpty() && !cover.startsWith("https://")) {
                bookVO.setCover("https://medicineonline.oss-cn-hangzhou.aliyuncs.com/" + cover);
            }
        }
        return list;
    }
    
}
