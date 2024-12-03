package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.entity.BookCategory;
import medicine.online.client.backend.model.vo.BookCategoryVO;
import medicine.online.client.backend.model.vo.BookVO;
import medicine.online.client.backend.service.BookCategoryService;
import medicine.online.client.backend.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description BookController
 */
@Tag(name = "知识库模块")
@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    private final BookCategoryService bookCategoryService;

    @PostMapping("/category")
    @Operation(summary = "书本分类")
    public Result<List<BookCategoryVO>> getCategoryList() {
        return Result.ok(bookCategoryService.getBookCategoryList());
    }

    @PostMapping("/list")
    @Operation(summary = "书本列表")
    public Result<List<BookVO>> getList(Integer categoryId) {
        return Result.ok(bookService.getBookListByCategoryId(categoryId));
    }
}