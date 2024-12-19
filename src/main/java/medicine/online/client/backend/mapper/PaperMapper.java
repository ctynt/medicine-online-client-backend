package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.client.backend.model.dto.PaperBankQuestion;
import medicine.online.client.backend.model.entity.Paper;
import medicine.online.client.backend.model.query.QuestionQuery;
import org.apache.ibatis.annotations.*;

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
    @Select("SELECT DISTINCT b.pk_id, b.option_type, b.question, pd.pk_id as detail_id " +
            "FROM t_quiz_paper_detail pd " +
            "LEFT JOIN t_quiz_bank b ON pd.question_id = b.pk_id " +
            "WHERE pd.content_id = #{paperId} " +
            "ORDER BY pd.pk_id ASC")
    @Results({
        @Result(property = "pkId", column = "pk_id"),
        @Result(property = "optionType", column = "option_type"),
        @Result(property = "question", column = "question"),
        @Result(property = "options", column = "pk_id",
            many = @Many(select = "medicine.online.client.backend.mapper.BankOptionMapper.findByBankId"))
    })
    List<PaperBankQuestion> getPaperQuestions(Page<PaperBankQuestion> page, @Param("paperId") Integer paperId);
}
