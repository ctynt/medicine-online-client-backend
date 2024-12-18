package medicine.online.client.backend.service.impl;


import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.cache.RedisCache;
import medicine.online.client.backend.common.cache.RedisKeys;
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
import medicine.online.client.backend.model.vo.PaperQuestionVO;
import medicine.online.client.backend.service.ExamService;
import medicine.online.client.backend.utils.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: minder
 * @createTime: 2024/12/15 17:32
 * @description:
 **/
@Service
@AllArgsConstructor
@Slf4j
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
    @Resource
    private ExamMapper examMapper;
    private final BankMapper bankMapper;
    private final PaperMapper paperMapper;
    private final PaperDetailMapper paperDetailMapper;
    private final RedisCache redisCache;
    private final HttpServletRequest request;

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
        // 获取试卷所有题目信息
        List<PaperQuestionVO> paperQuestions = examMapper.getPaperQuestions(submitDTO.getPaperId());
        if (paperQuestions.isEmpty()) {
            throw new IllegalStateException("未找到试卷题目");
        }

        try {
            // 从请求头获取token并解析userId
            String token = request.getHeader("Authorization");
            if (token != null) {
                JSONObject claims = JwtUtil.getJSONObject(token);
                Integer userId = claims.getInt("userId");
                
                if (userId != null) {
                    // 存储答题记录，使用试卷ID作为key的一部分
                    String key = RedisKeys.getQuizUserDetail(submitDTO.getPaperId().toString());
                    redisCache.set(key, userId, RedisCache.HOUR_SIX_EXPIRE);
                    log.info("答题记录已缓存 - key: {}, value: {}", key, userId);
                }
            }
        } catch (Exception e) {
            log.error("Redis缓存答题记录失败: ", e);
        }

        // 计算得分
        int totalScore = 0;
        int correctCount = 0;

        // 将用户答案转换为Map，方便查找
        Map<Integer, String> userAnswers = submitDTO.getAnswers().stream()
                .collect(Collectors.toMap(AnswerDTO::getPkId, AnswerDTO::getAnswer));

        for (PaperQuestionVO question : paperQuestions) {
            String userAnswer = userAnswers.get(question.getQuestionId());
            if (userAnswer != null && userAnswer.equals(question.getCorrectAnswer())) {
                correctCount++;
                // 根据题目类型计算分数
                switch (question.getOptionType()) {
                    case 0: // 单选
                        totalScore += question.getSimpleScore();
                        break;
                    case 1: // 多选
                        totalScore += question.getMultipleScore();
                        break;
                    case 2: // 填空
                        totalScore += question.getBlankScore();
                        break;
                }
            }
        }

        // 计算总分（所有题目满分）
        int maxPossibleScore = calculateTotalPossibleScore(paperQuestions);

        // 构建返回结果
        ExamResultVO result = new ExamResultVO();
        result.setTotalScore(maxPossibleScore);
        result.setScore(totalScore);
        result.setCorrectCount(correctCount);
        result.setTotalCount(paperQuestions.size());
        result.setPassScore(paperQuestions.get(0).getPassScore());
        result.setIsPassed(totalScore >= paperQuestions.get(0).getPassScore());

        return result;
    }

    /**
     * 计算试卷总分
     */
    private int calculateTotalPossibleScore(List<PaperQuestionVO> questions) {
        return questions.stream()
                .mapToInt(q -> {
                    switch (q.getOptionType()) {
                        case 0: return q.getSimpleScore();
                        case 1: return q.getMultipleScore();
                        case 2: return q.getBlankScore();
                        default: return 0;
                    }
                })
                .sum();
    }
}
