package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.mapper.ExamMapper;
import medicine.online.client.backend.model.dto.PaperBankQuestion;
import medicine.online.client.backend.model.entity.Exam;
import medicine.online.client.backend.model.entity.Quiz;
import medicine.online.client.backend.model.query.Query;
import medicine.online.client.backend.model.query.QuestionQuery;
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

    @PostMapping("/exam")
    @Operation(summary = "试卷列表")
    public Result<List<Exam>> getExamList(@RequestParam Integer quizDetailId){
        return Result.ok(examService.getExamList(quizDetailId));
    }

    @PostMapping("/questionList")
    @Operation(summary = "题目选项")
    public Result<PageResult<PaperBankQuestion>> list(@RequestBody @Valid QuestionQuery query){
        return Result.ok(paperService.getPaperQuestionsByExamId(query));
    }
}
