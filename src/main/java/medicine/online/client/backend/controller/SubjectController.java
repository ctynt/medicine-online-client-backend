package medicine.online.client.backend.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.vo.BookVO;
import medicine.online.client.backend.model.vo.PodcastVO;
import medicine.online.client.backend.model.vo.SubjectLabelVO;
import medicine.online.client.backend.model.vo.SubjectVO;
import medicine.online.client.backend.service.BookService;
import medicine.online.client.backend.service.PodcastService;
import medicine.online.client.backend.service.SubjectLabelService;
import medicine.online.client.backend.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name =  "专题接口", description = "专题接口")
@RequestMapping("index")
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/exclusiveItemList")
    @Operation(summary = "专属专题列表")
    public Result<List<SubjectVO>> getSubjectList() {
        return Result.ok(subjectService.getSubjectList());
    }

    @GetMapping("/publicItemList")
    @Operation(summary = "公共专题列表")
    public Result<List<SubjectVO>> getSubjectList0() {
        return Result.ok(subjectService.getSubjectList0());
    }

    @GetMapping("/itemListDetail/{id}")
    @Operation(summary = "专题详情介绍")
    public Result<SubjectVO> getSubjectDetail(@PathVariable Integer id) {
        return Result.ok(subjectService.getSubjectDetail(id));
    }

    private final BookService bookService;

    @GetMapping("/bookList")
    @Operation(summary = "专题书籍列表")
    public Result<List<BookVO>> index(@RequestParam Integer subjectId) {
        return Result.ok(bookService.ztBook(subjectId));
    }

    private final PodcastService podcastService;

    @GetMapping("/podcastList")
    @Operation(summary = "专题音频列表")
    public Result<List<PodcastVO>> ztPodcast(@RequestParam Integer subjectId) {
        return Result.ok(podcastService.ztPodcast(subjectId));
    }

    private final SubjectLabelService subjectLabelService;

    @GetMapping("/videosList")
    @Operation(summary = "专题视频集列表")
    public Result<List<SubjectLabelVO>> getSubjectLabelList(@RequestParam Integer subjectId) {
        return Result.ok(subjectLabelService.getSubjectLabelList(subjectId));
    }
}
