package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.QuizItem;
import medicine.online.client.backend.model.vo.QuizItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 17:07
 * @description:
 **/
public interface QuizItemMapper extends BaseMapper<QuizItemVO> {
    List<QuizItemVO> selectQuizItemByExamineId(@Param("examineId") Integer examineId);
}
