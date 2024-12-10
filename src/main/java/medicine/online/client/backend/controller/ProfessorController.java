package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.vo.ProfessorCategoryVO;
import medicine.online.client.backend.model.query.ProfessorQuery;
import medicine.online.client.backend.model.vo.ProfessorDetailVO;
import medicine.online.client.backend.model.vo.ProfessorVO;
import medicine.online.client.backend.model.vo.TopicVO;
import medicine.online.client.backend.service.ProfessorCategoryService;
import medicine.online.client.backend.service.ProfessorService;
import medicine.online.client.backend.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@RestController
@RequestMapping("/professor")
@Tag(name = "专家咨询模块")
@AllArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;
    private final TopicService topicService;
    private final ProfessorCategoryService professorCategoryService;

    @PostMapping("/list")
    @Operation(summary = "专家列表")
    public Result<PageResult<ProfessorVO>> list(@RequestBody @Valid ProfessorQuery query) {
        return Result.ok(professorService.getProfessorList(query));
    }

    @PostMapping("/category")
    @Operation(summary = "专家目录分类")
    public Result<List<ProfessorCategoryVO>> getProfessorCategories() {
        return Result.ok(professorCategoryService.listCategoryForCustomer());
    }

    @PostMapping("/detail/{id}")
    @Operation(summary = "专家详情")
    public Result<ProfessorDetailVO> getProfessorDetail(@PathVariable Integer id) {
        return Result.ok(professorService.getProfessorDetail(id));
    }

    @PostMapping("/search")
    @Operation(summary = "专家搜索")
    public Result<List<ProfessorVO>> getListByName(@RequestParam String name) {
        return Result.ok(professorService.getProfessorListByName(name));
    }

    @PostMapping("/topicList/{id}")
    @Operation(summary = "专家问答列表")
    public Result<List<TopicVO>> getTopicList(@PathVariable Integer id) {
        return Result.ok(topicService.getTopicList(id));
    }

    @PostMapping("/replyList/{id}")
    @Operation(summary = "回复列表")
    public Result<List<Map<String, Object>>> getTopicReplyList(@PathVariable Integer id) {
        return Result.ok(topicService.getTopicReplyList(id));
    }
}
