package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.Exam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/15 17:26
 * @description:
 **/
public interface ExamMapper extends BaseMapper<Exam> {
    List<Exam> selectExamByDetailId(@Param("quizDetailId") Integer quizDetailId);

    List<Exam> selectExamsByExamineId(@Param("examineId") Integer examineId);
}
