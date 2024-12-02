package medicine.online.client.backend.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.mapper.BookMapper;
import medicine.online.client.backend.model.entity.Book;
import medicine.online.client.backend.model.vo.BookVO;
import medicine.online.client.backend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Override
    public List<BookVO> ztBook(Integer subjectId) {
        return baseMapper.ztBook(subjectId);
    }
}
