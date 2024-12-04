package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.convert.BookCategoryConvert;
import medicine.online.client.backend.mapper.BookCategoryMapper;
import medicine.online.client.backend.model.entity.BookCategory;
import medicine.online.client.backend.model.vo.BookCategoryVO;
import medicine.online.client.backend.service.BookCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookCategoryServiceImpl
 */
@Slf4j
@Service
@AllArgsConstructor
public class BookCategoryServiceImpl extends ServiceImpl<BookCategoryMapper, BookCategory> implements BookCategoryService {
    @Override
    public List<BookCategoryVO> getBookCategoryList(){
        List<BookCategory> bookCategoryList = baseMapper.selectList(null);
        return BookCategoryConvert.INSTANCE.convert(bookCategoryList);
    }
}
