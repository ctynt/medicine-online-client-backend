package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.query.ProfessorQuery;
import medicine.online.client.backend.model.vo.ProfessorVO;
import medicine.online.client.backend.service.ProfessorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/list")
    @Operation(summary = "专家列表")
    public Result<List<ProfessorVO>> list(@RequestBody ProfessorQuery query) {
        return Result.ok(professorService.getProfessorList(query.getCategoryId()));
    }
}
