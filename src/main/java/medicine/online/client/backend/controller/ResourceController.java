package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.vo.*;
import medicine.online.client.backend.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "知识库模块")
@RestController
@RequestMapping("/resource")
@AllArgsConstructor
public class ResourceController {

    private final BookService bookService;

    private final BookCategoryService bookCategoryService;

    private final BookChapterService bookChapterService;

    private final ResourceCategoryService resourceCategoryService;

    private final CourseService courseService;

    @PostMapping("/book/category")
    @Operation(summary = "书本分类")
    public Result<List<BookCategoryVO>> getCategoryList() {
        return Result.ok(bookCategoryService.getBookCategoryList());
    }

    @PostMapping("/book/list")
    @Operation(summary = "书本列表")
    public Result<List<BookVO>> getList(@RequestParam String categoryName) {
        return Result.ok(bookService.getBookListByCategory(categoryName));
    }

    @PostMapping("/book/getBookChapterList/{bookId}")
    @Operation(summary = "获取书籍章节")
    public Result<List<BookChapterVO>> getListById(@PathVariable Integer bookId) {
        return Result.ok(bookChapterService.getListById(bookId));
    }

    @PostMapping("/category")
    @Operation(summary = "资源分类")
    public Result<List<ResourceCategoryVO>> getResourceCategoryList(@RequestParam Integer parentId) {
        return Result.ok(resourceCategoryService.getResourceCategoryTree(parentId));
    }

    @PostMapping("/video/list")
    @Operation(summary = "视频列表")
    public Result<List<CourseVO>> getCourseList(@RequestParam String categoryName) {
        return Result.ok(courseService.getCourseList(categoryName));
    }
}
