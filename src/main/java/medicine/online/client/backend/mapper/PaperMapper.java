package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.client.backend.model.dto.PaperBankQuestion;
import medicine.online.client.backend.model.entity.Paper;
import medicine.online.client.backend.model.query.QuestionQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/15 20:39
 * @description:
 **/
public interface PaperMapper extends BaseMapper<Paper> {
    List<PaperBankQuestion> selectPagedQuestions(Page<PaperBankQuestion> page, @Param("query")QuestionQuery query);
    @Select("SELECT * FROM t_quiz_paper WHERE quiz_exam_id = #{examId} AND delete_flag = 0 LIMIT 1")
    Paper selectByExamId(@Param("examId") Integer examId);
}
