package medicine.online.client.backend.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.query.NewsQuery;
import medicine.online.client.backend.model.vo.NewsVO;
import medicine.online.client.backend.service.NewsService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Tag(name = "资讯接口", description = "资讯列表")
@RequestMapping
public class NewsController {
    private final NewsService newsService;

//    @GetMapping("/newsList")
//    @Operation(summary = "资讯列表")
//    public Result<List<NewsVO>> index() {
//        return Result.ok(newsService.indexPageNews());
//    }

    @PostMapping("/newsList/page")
    @Operation(summary = "分页资讯列表")
    public Result<PageResult<NewsVO>> page(@RequestBody @Valid NewsQuery query) {
        return Result.ok(newsService.getNewsList(query));
    }

    @GetMapping("/newsListDetail/{id}")
    @Operation(summary = "资讯详情")
    public Result<NewsVO> detail(@PathVariable Integer id) {
        return Result.ok(newsService.getNewsDetail(id));
    }
}