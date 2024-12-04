package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.vo.ProfessorCategoryVO;
import medicine.online.client.backend.model.query.ProfessorQuery;
import medicine.online.client.backend.model.vo.ProfessorDetailVO;
import medicine.online.client.backend.model.vo.ProfessorVO;
import medicine.online.client.backend.service.ProfessorCategoryService;
import medicine.online.client.backend.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private final ProfessorCategoryService professorCategoryService;

    @PostMapping("/list")
    @Operation(summary = "专家列表")
    public Result<List<ProfessorVO>> list(@RequestBody ProfessorQuery query) {
        return Result.ok(professorService.getProfessorList(query.getCategoryId()));
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


}
