package medicine.online.client.backend.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.exception.ErrorCode;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.vo.CourseVO;
import medicine.online.client.backend.model.vo.NewsVO;
import medicine.online.client.backend.model.vo.PodcastVO;
import medicine.online.client.backend.model.vo.SubjectVO;
import medicine.online.client.backend.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "首页搜索")
@RequestMapping("index")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    @Operation(summary = "首页分页分类搜索")
    public Result<Page<Object>> searchByTitle(@RequestParam String title,
                                              @RequestParam(required = false) Integer leixing,
                                              @RequestParam(defaultValue = "1") Integer pageNum, // 页码，默认从第1页开始
                                              @RequestParam(defaultValue = "10") Integer pageSize  // 每页数量
    ) {

        try {
            Page<Object> resultPage = new Page<>(pageNum, pageSize);

            List<Object> allDataList = new ArrayList<>();

            // 查询专题表数据
            // 重新实例化对应类型的Page对象
            Page<SubjectVO> subjectVOPage = searchService.getSubjectByTitleLike(title, new Page<>(pageNum, pageSize));
            List<SubjectVO> subjectVOList = subjectVOPage.getRecords();
            for (SubjectVO subjectVO : subjectVOList) {
                if (isSubjectPkIdExist(subjectVO.getPkId())) {
                    subjectVO.setLeixing(0);
                    allDataList.add(subjectVO);
                }
            }

            // 查询资讯表数据
            // 重新实例化对应类型的Page对象
            Page<NewsVO> newsVOPage = searchService.getNewsByTitleLike(title, new Page<>(pageNum, pageSize));
            List<NewsVO> newsVOList = newsVOPage.getRecords();
            for (NewsVO newsVO : newsVOList) {
                if (isNewsPkIdExist(newsVO.getPkId())) {
                    newsVO.setLeixing(1);
                    allDataList.add(newsVO);
                }
            }

            // 查询课程表数据
            // 重新实例化对应类型的Page对象
            Page<CourseVO> courseVOPage = searchService.getCourseByTitleLike(title, new Page<>(pageNum, pageSize));
            List<CourseVO> courseVOList = courseVOPage.getRecords();
            for (CourseVO courseVO : courseVOList) {
                if (isCoursePkIdExist(courseVO.getPkId())) {
                    courseVO.setLeixing(2);
                    allDataList.add(courseVO);
                }
            }

            // 查询音频表数据
            // 重新实例化对应类型的Page对象
            Page<PodcastVO> podcastVOPage = searchService.getPodcastByTitleLike(title, new Page<>(pageNum, pageSize));
            List<PodcastVO> podcastVOList = podcastVOPage.getRecords();
            for (PodcastVO podcastVO : podcastVOList) {
                if (isPodcastPkIdExist(podcastVO.getPkId())) {
                    podcastVO.setLeixing(3);
                    allDataList.add(podcastVO);
                }
            }

            // 如果提供了leixing参数，根据leixing过滤结果
            if (leixing != null) {
                List<Object> filteredList = new ArrayList<>();
                for (Object obj : allDataList) {
                    if (obj instanceof SubjectVO && leixing == 0) {
                        filteredList.add(obj);
                    } else if (obj instanceof NewsVO && leixing == 1) {
                        filteredList.add(obj);
                    } else if (obj instanceof CourseVO && leixing == 2) {
                        filteredList.add(obj);
                    } else if (obj instanceof PodcastVO && leixing == 3) {
                        filteredList.add(obj);
                    }
                }
                resultPage.setRecords(filteredList);
                resultPage.setTotal(filteredList.size());
            } else {
                // 如果没有提供leixing参数，返回所有类型的数据
                resultPage.setRecords(allDataList);
                resultPage.setTotal(allDataList.size());
            }

            // 查询成功，返回包含数据的Result对象， 状态码为0表示成功
            return Result.ok(resultPage);
        } catch (Exception e) {
            // 出现异常情况，返回错误的 Result 对象，这里使用了 ErrorCode 中的内部服务器错误码
            return Result.error(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean isSubjectPkIdExist(Integer pkId) {
        return searchService.isSubjectPkIdExist(pkId);
    }

    private boolean isNewsPkIdExist(Integer pkId) {
        return searchService.isNewsPkIdExist(pkId);
    }

    private boolean isCoursePkIdExist(Integer pkId) {
        return searchService.isCoursePkIdExist(pkId);
    }

    private boolean isPodcastPkIdExist(Integer pkId) {
        return searchService.isPodcastPkIdExist(pkId);
    }
}