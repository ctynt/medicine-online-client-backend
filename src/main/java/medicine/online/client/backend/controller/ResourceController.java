package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.vo.BookCategoryVO;
import medicine.online.client.backend.model.vo.BookChapterVO;
import medicine.online.client.backend.model.vo.BookVO;
import medicine.online.client.backend.model.vo.ResourceCategoryVO;
import medicine.online.client.backend.service.BookCategoryService;
import medicine.online.client.backend.service.BookChapterService;
import medicine.online.client.backend.service.BookService;
import medicine.online.client.backend.service.ResourceCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description ResourceController
 */
@Tag(name = "知识库模块")
@RestController
@RequestMapping("/resource")
@AllArgsConstructor
public class ResourceController {

    private final BookService bookService;

    private final BookCategoryService bookCategoryService;

    private final BookChapterService bookChapterService;

    private final ResourceCategoryService resourceCategoryService;

    @PostMapping("/book/category")
    @Operation(summary = "书本分类")
    public Result<List<BookCategoryVO>> getCategoryList() {
        return Result.ok(bookCategoryService.getBookCategoryList());
    }

    @PostMapping("/book/list")
    @Operation(summary = "书本列表")
    public Result<List<BookVO>> getList(Integer categoryId) {
        return Result.ok(bookService.getBookListByCategoryId(categoryId));
    }

    @PostMapping("/book/getBookChapterList/{bookId}")
    @Operation(summary = "获取书籍章节")
    public Result<List<BookChapterVO>> getListById(@PathVariable Integer bookId) {
        return Result.ok(bookChapterService.getListById(bookId));
    }

    @PostMapping("/category")
    @Operation(summary = "资源分类")
    public Result<List<ResourceCategoryVO>> getResourceCategoryList(Integer parentId) {
        return Result.ok(resourceCategoryService.getResourceCategoryTree(parentId));
    }
}
