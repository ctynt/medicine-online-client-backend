package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.BookCategory;
import medicine.online.client.backend.model.vo.BookCategoryVO;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookCategoryService
 */

public interface BookCategoryService extends IService<BookCategory> {
    List<BookCategoryVO> getBookCategoryList();
}
