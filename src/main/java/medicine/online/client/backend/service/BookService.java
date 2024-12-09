package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.Book;
import medicine.online.client.backend.model.vo.BookVO;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookService
 */

public interface BookService extends IService<Book> {
    List<BookVO> getBookListByCategory(String categoryName);
}
