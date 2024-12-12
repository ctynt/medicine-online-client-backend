package medicine.online.client.backend.controller;

import cn.hutool.json.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.dto.InsertDTO;
import medicine.online.client.backend.model.dto.ReplyDTO;
import medicine.online.client.backend.model.query.ProfessorQuery;
import medicine.online.client.backend.model.vo.*;
import medicine.online.client.backend.service.ProfessorCategoryService;
import medicine.online.client.backend.service.ProfessorService;
import medicine.online.client.backend.service.TopicService;
import medicine.online.client.backend.utils.JwtUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Result<PageResult<ProfessorVO>> list(@RequestBody ProfessorQuery query) {
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

    @PostMapping(value = "/insert")
    @Operation(summary = "发起提问")
    public Result<InsertVO> submitQuestion(
            HttpServletRequest request,
            @Parameter(description = "教授id") @RequestParam Integer professorId,
            @Parameter(description = "内容") @RequestParam String content,
            @Parameter(description = "图片文件") @RequestParam(required = false) MultipartFile imgFile) {

        // 从请求头中解析用户ID
        String token = request.getHeader("Authorization");
        JSONObject claims = JwtUtil.getJSONObject(token);
        Integer userId = claims.getInt("userId");

        InsertDTO insertDTO = new InsertDTO();
        insertDTO.setUserId(userId);
        insertDTO.setProfessorId(professorId);
        insertDTO.setContent(content);
        if (imgFile != null && !imgFile.isEmpty()) {
            insertDTO.setImgFile(imgFile);
        }

        return Result.ok(topicService.submitQuestion(insertDTO));
    }


    @PostMapping(value = "/reply")
    @Operation(summary = "作答")
    public Result<ReplyVO> replyToTopic(
            HttpServletRequest request,
            @Parameter(description = "问题 ID") @RequestParam Integer topicId,
            @Parameter(description = "回复内容") @RequestParam String content,
            @Parameter(description = "图片文件") @RequestParam(required = false) MultipartFile imgFile) {

        // 解析用户ID
        String token = request.getHeader("Authorization");
        JSONObject claims = JwtUtil.getJSONObject(token);
        Integer userId = claims.getInt("userId");

        ReplyDTO replyDTO = new ReplyDTO();
        replyDTO.setUserId(userId);
        replyDTO.setTopicId(topicId);
        replyDTO.setContent(content);
        if (imgFile != null && !imgFile.isEmpty()) {
            replyDTO.setImgFile(imgFile);
        }

        return Result.ok(topicService.replyToTopic(replyDTO));
    }
}



