package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.Book;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookMapper
 */

public interface BookMapper extends BaseMapper<Book> {
    default List<Book> selectListByCategoryId(Integer categoryId){
        return this.selectList(new LambdaQueryWrapper<Book>().eq(Book::getCategoryId, categoryId));
    }
}