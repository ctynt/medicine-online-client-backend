package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.Exam;
import medicine.online.client.backend.model.vo.PaperQuestionVO;
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

    /**
     * 获取试卷的所有题目和分数信息
     * @param paperId 试卷ID
     * @return 试卷题目信息列表
     */
    List<PaperQuestionVO> getPaperQuestions(@Param("paperId") Integer paperId);

}
