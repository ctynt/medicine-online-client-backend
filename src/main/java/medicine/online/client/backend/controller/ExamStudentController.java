package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.exception.ServerException;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.dto.StartExamDTO;
import medicine.online.client.backend.model.entity.Exam;
import medicine.online.client.backend.service.ExamService;
import medicine.online.client.backend.service.IExamStudentService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Tag(name = "考试学生管理")
@RestController
@RequestMapping("/exam/student")
@AllArgsConstructor
public class ExamStudentController {

    private final IExamStudentService examStudentService;
    private final ExamService examService;

    @PostMapping("/start")
    @Operation(summary = "开始考试")
    public Result<Boolean> startExam(@RequestBody @Valid StartExamDTO startExamDTO) {
        // 验证考试是否存在
        Exam exam = examService.getById(startExamDTO.getExamId());
        if (exam == null) {
            throw new ServerException("考试不存在");
        }
        
        // 验证考试时间
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(exam.getStartTime()) || now.isAfter(exam.getEndTime())) {
            throw new ServerException("不在考试时间范围内");
        }
        
        // 验证考试是否已开始
        if (exam.getIsStart() != 1) {
            throw new ServerException("考试未开始");
        }

        boolean result = examStudentService.startExam(
            startExamDTO.getExamId(),
            startExamDTO.getStudentId()
        );
        
        return Result.ok(result);
    }

    @GetMapping("/detail/{detail}")
    @Operation(summary = "获取考试答题记录")
    public Result<String> getQuizUserDetail(@PathVariable("detail") String detail) {
        String result = examStudentService.getQuizUserDetail(detail);
        return Result.ok(result);
    }
} 