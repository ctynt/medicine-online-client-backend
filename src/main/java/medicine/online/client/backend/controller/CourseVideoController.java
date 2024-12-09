package medicine.online.client.backend.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.vo.CourseVideoVO;
import medicine.online.client.backend.service.CourseVideoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Tag(name = "视频详情接口", description = "课程详情接口")
public class CourseVideoController {
    private final CourseVideoService courseVideoService;

    @PostMapping("/courseDetail/{id}")
    @Operation(summary = "视频详情")
    public Result<CourseVideoVO> getCourseVideoDetail(@PathVariable Integer id) {
        return Result.ok(courseVideoService.getCourseVideoDetail(id));
    }
}
