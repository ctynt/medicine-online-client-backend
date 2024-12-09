package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.BookCategory;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookCategoryMapper
 */

public interface BookCategoryMapper extends BaseMapper<BookCategory> {

    default BookCategory getCategoryId(String categoryName){
        return this.selectOne(new LambdaQueryWrapper<BookCategory>().eq(BookCategory::getTitle,categoryName));
    }
}
