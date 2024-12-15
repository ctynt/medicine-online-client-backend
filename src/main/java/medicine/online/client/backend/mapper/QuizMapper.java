package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.client.backend.model.entity.Quiz;
import medicine.online.client.backend.model.query.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 16:12
 * @description:
 **/
public interface QuizMapper extends BaseMapper<Quiz> {
    List<Quiz> getQuizList(Page<Quiz> page, @Param("query")Query query);
}
