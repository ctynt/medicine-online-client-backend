package medicine.online.client.backend.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.vo.rCategoryVO;
import medicine.online.client.backend.service.rCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "专题接口")
@RequestMapping("/index")
public class rCategoryController {
    private final rCategoryService rcategoryService;

    @GetMapping("/item/category")
    @Operation(summary = "专题视频分类列表")
    public Result<List<rCategoryVO>> queryByLevel() {
        return Result.ok(rcategoryService.getrCategoryList());
    }

    @GetMapping("/item/categorylist")
    @Operation(summary = "专题视频分类子列表")
    public Result<List<rCategoryVO>> getrCategoryListByParentId(@RequestParam(required = false) Long parentId) {
        return Result.ok(rcategoryService.getrCategoryListByParentId(parentId));
    }
}
