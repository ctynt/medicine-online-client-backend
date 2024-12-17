package medicine.online.client.backend.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.exception.ServerException;
import medicine.online.client.backend.mapper.BankMapper;
import medicine.online.client.backend.mapper.ExamMapper;
import medicine.online.client.backend.mapper.PaperDetailMapper;
import medicine.online.client.backend.mapper.PaperMapper;
import medicine.online.client.backend.model.dto.AnswerDTO;
import medicine.online.client.backend.model.dto.ExamSubmitDTO;
import medicine.online.client.backend.model.entity.Bank;
import medicine.online.client.backend.model.entity.Exam;
import medicine.online.client.backend.model.entity.Paper;
import medicine.online.client.backend.model.entity.PaperDetail;
import medicine.online.client.backend.model.vo.ExamResultVO;
import medicine.online.client.backend.service.ExamService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: minder
 * @createTime: 2024/12/15 17:32
 * @description:
 **/
@Service
@AllArgsConstructor
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
    @Resource
    private ExamMapper examMapper;
    private final BankMapper bankMapper;
    private final PaperMapper paperMapper;
    private final PaperDetailMapper paperDetailMapper;

    @Override
    public List<Exam> getExamList(Integer quizDetailId) {
        return examMapper.selectExamByDetailId(quizDetailId);
    }

    @Override
    public List<Exam> getExamsByExamineId(Integer examineId) {
        return baseMapper.selectExamsByExamineId(examineId);
    }

    @Override
    public ExamResultVO submitExam(ExamSubmitDTO submitDTO) {
        // 1. 获取试卷配置信息
        Paper paper = paperMapper.selectByExamId(submitDTO.getExamId());
        if (paper == null) {
            throw new ServerException("试卷不存在");
        }

        // 2. 验证答题的题目是否属于该试卷
        List<PaperDetail> paperDetails = paperDetailMapper.selectList(
                new LambdaQueryWrapper<PaperDetail>()
                        .eq(PaperDetail::getContentId, paper.getPkId())
        );

        // 创建题目ID集合用于验证
        Set<Integer> validQuestionIds = paperDetails.stream()
                .map(PaperDetail::getQuestionId)
                .collect(Collectors.toSet());

        int totalScore = 0;
        int correctCount = 0;
        int totalCount = submitDTO.getAnswers().size();

        // 3. 遍历答案进行评分
        for (AnswerDTO answer : submitDTO.getAnswers()) {
            // 验证题目是否属于该试卷
            if (!validQuestionIds.contains(answer.getPkId())) {
                continue;
            }

            // 获取题目信息
            Bank question = bankMapper.selectById(answer.getPkId());
            if (question == null) {
                continue;
            }

            // 答案比对
            boolean isCorrect = false;
            switch (answer.getOptionType()) {
                case 0: // 单选
                case 1: // 多选
                    String standardizedSubmitted = standardizeAnswer(answer.getAnswer());
                    String standardizedCorrect = standardizeAnswer(question.getAnswer());
                    isCorrect = standardizedSubmitted.equals(standardizedCorrect);
                    break;
                case 2: // 填空
                    isCorrect = answer.getAnswer().equals(question.getAnswer());
                    break;
            }

            if (isCorrect) {
                correctCount++;
                // 根据题目类型计算得分
                switch (answer.getOptionType()) {
                    case 0: // 单选
                        totalScore += paper.getSimpleScore();
                        break;
                    case 1: // 多选
                        totalScore += paper.getMultipleScore();
                        break;
                    case 2: // 填空
                        totalScore += paper.getBlankScore();
                        break;
                }
            }
        }

        // 4. 返回结果
        return ExamResultVO.builder()
                .totalScore(paper.getScore())
                .score(totalScore)
                .correctCount(correctCount)
                .totalCount(totalCount)
                .build();
    }

    private String standardizeAnswer(String answer) {
        if (answer == null || answer.isEmpty()) {
            return "";
        }
        char[] chars = answer.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
