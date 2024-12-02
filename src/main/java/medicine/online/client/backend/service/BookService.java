package medicine.online.client.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.Book;
import medicine.online.client.backend.model.vo.BookVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService extends IService<Book> {

    // 定义获取书籍方法
    List<BookVO> ztBook(@Param("subjectId") Integer subjectId);

}
