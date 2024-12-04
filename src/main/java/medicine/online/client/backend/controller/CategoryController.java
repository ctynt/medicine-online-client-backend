package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.vo.CategoryVO;
import medicine.online.client.backend.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
@Tag(name = "首页分类")
@RequestMapping("/index")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/category")
    @Operation(summary = "首页分类列表")
    public Result<List<CategoryVO>> queryByLevel() {
        return Result.ok(categoryService.getCategoryList());
    }

    @GetMapping("/categorylist")
    @Operation(summary = "首页分类子列表")
    public List<CategoryVO> getCategoryListByParentId(@RequestParam(required = false) Long parentId) {
        return categoryService.getCategoryListByParentId(parentId);
    }


}

