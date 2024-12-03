package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.convert.BookChapterConvert;
import medicine.online.client.backend.mapper.BookChapterMapper;
import medicine.online.client.backend.model.entity.BookChapter;
import medicine.online.client.backend.model.vo.BookChapterVO;
import medicine.online.client.backend.service.BookChapterService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookChapterServiceImpl
 */
@Slf4j
@Service
@AllArgsConstructor
public class BookChapterServiceImpl extends ServiceImpl<BookChapterMapper, BookChapter> implements BookChapterService {
    @Override
    public List<BookChapterVO> getListById(Integer bookId){
        List<BookChapter> bookChapterList = baseMapper.getChapterList(bookId);
        return BookChapterConvert.INSTANCE.convert(bookChapterList);
    }
}
