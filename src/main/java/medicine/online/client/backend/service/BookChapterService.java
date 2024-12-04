package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.BookChapter;
import medicine.online.client.backend.model.vo.BookChapterVO;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookChapterService
 */

public interface BookChapterService extends IService<BookChapter> {
    List<BookChapterVO> getListById(Integer bookId);
}
