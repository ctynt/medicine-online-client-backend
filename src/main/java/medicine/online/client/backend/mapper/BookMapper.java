package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.Book;
import medicine.online.client.backend.model.vo.BookVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper extends BaseMapper<Book> {

    // 获取书籍方法
    List<BookVO> ztBook(@Param("subjectId") Integer subjectId);
  
    default List<Book> selectListByCategoryId(Integer categoryId){
        return this.selectList(new LambdaQueryWrapper<Book>().eq(Book::getCategoryId, categoryId));
    }
}

