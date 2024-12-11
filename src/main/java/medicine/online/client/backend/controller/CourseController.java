package medicine.online.client.backend.controller;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.query.Query;
import medicine.online.client.backend.model.vo.CourseVO;
import medicine.online.client.backend.service.CourseService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Tag(name = "视频接口", description = "视频接口")
@RequestMapping()
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/index/courseList")
    @Operation(summary = "首页分页上新视频接口")
    public Result<PageResult<CourseVO>> getsPageCourseList(@RequestBody @Valid Query query) {
        return Result.ok(courseService.getsPageCourseList(query));
    }

    @PostMapping("/item/courseList/{subjectId}/{categoryId}")
    @Operation(summary = "专题分页视频列表")
    public Result<PageResult<CourseVO>> page(@RequestBody @Valid Query query,@PathVariable Integer subjectId, @PathVariable Integer categoryId) {
        return Result.ok(courseService.getPageCourseList(query, subjectId, categoryId));
    }

    @PostMapping("/item/videos/{videosId}")
    @Operation(summary = "专题分页视频集列表")
    public Result<PageResult<CourseVO>> getPageVideosList(@RequestBody @Valid Query query, @PathVariable Integer videosId) {
        return Result.ok(courseService.getPageVideosList(query, videosId));
    }
}
