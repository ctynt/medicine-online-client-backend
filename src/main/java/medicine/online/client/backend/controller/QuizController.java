package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.exception.ErrorCode;
import medicine.online.client.backend.common.exception.ServerException;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.mapper.ExamMapper;
import medicine.online.client.backend.model.dto.ExamSubmitDTO;
import medicine.online.client.backend.model.dto.PaperBankQuestion;
import medicine.online.client.backend.model.entity.Exam;
import medicine.online.client.backend.model.entity.Quiz;
import medicine.online.client.backend.model.query.Query;
import medicine.online.client.backend.model.query.QuestionQuery;
import medicine.online.client.backend.model.vo.ExamResultVO;
import medicine.online.client.backend.model.vo.QuizItemVO;
import medicine.online.client.backend.service.ExamService;
import medicine.online.client.backend.service.PaperService;
import medicine.online.client.backend.service.QuizItemService;
import medicine.online.client.backend.service.QuizService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 16:24
 * @description:
 **/
@RestController
@RequestMapping("/quiz")
@Tag(name = "考核模块")
@AllArgsConstructor
public class QuizController {
    private final QuizService quizService;
    private final QuizItemService quizItemService;
    private final ExamService examService;
    private final PaperService paperService;

    @PostMapping("/list")
    @Operation(summary = "分页考核列表")
    public Result<PageResult<Quiz>> list(@RequestBody @Valid Query query){
        return Result.ok(quizService.getQuizList(query));
    }

    @PostMapping("/item/list")
    @Operation(summary = "考核子项列表")
    public Result<List<QuizItemVO>> getItemList(@RequestParam Integer examineId){
        return Result.ok(quizItemService.getItemList(examineId));
    }

    @PostMapping("/exam/{examineId}")
    @Operation(summary = "试卷列表")
    public Result<List<Exam>> getExamList(@PathVariable Integer examineId){
        return Result.ok(examService.getExamsByExamineId(examineId));
    }

    @PostMapping("/questionList")
    @Operation(summary = "获取试卷题目选项")
    public Result<PageResult<PaperBankQuestion>> list(@RequestBody @Valid QuestionQuery query){
        if (query.getPaperId() == null) {
            throw new ServerException(ErrorCode.PARAMS_ERROR);
        }
        return Result.ok(paperService.getPaperQuestionsByPaperId(query));
    }

    @PostMapping("/submit")
    @Operation(summary = "提交试卷")
    public Result<ExamResultVO> submitExam(@RequestBody @Valid ExamSubmitDTO submitDTO) {
        return Result.ok(examService.submitExam(submitDTO));
    }
}
