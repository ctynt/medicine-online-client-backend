package medicine.online.client.backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.model.vo.StarVO;
import medicine.online.client.backend.service.StarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangL
 */
@RestController
@RequestMapping("/star")
@Tag(name = "收藏模块")
@AllArgsConstructor
public class StarController {

    private final StarService starService;

    /**
     * 删除收藏
     */
    @PostMapping("/deleteCollection")
    @Operation(summary = "删除收藏")
    public ResponseEntity<Map<String, Object>> deleteCollection(@RequestBody Map<String, Object> requestParams) {
        Integer contentId = (Integer) requestParams.get("contentId");
        Integer type = (Integer) requestParams.get("type");

        Map<String, Object> response = new HashMap<>();

        if (contentId == null || type == null) {
            response.put("code", 400);
            response.put("msg", "缺少必要参数");
            return ResponseEntity.badRequest().body(response);
        }

        boolean isDeleted = starService.deleteCollection(contentId, type);

        if (isDeleted) {
            response.put("code", 200);
            response.put("msg", "删除收藏成功");
            response.put("data", null);
            // 删除操作成功后可以返回空数据
        } else {
            response.put("code", 500);
            response.put("msg", "删除收藏失败");
            response.put("data", null);
        }

        return ResponseEntity.ok(response);
    }

    /**
     * 添加收藏
     */
    @PostMapping("/addCollection")
    @Operation(summary = "添加收藏")
    public ResponseEntity<Map<String, Object>> addCollection(@RequestBody Map<String, Object> requestParams) {
        Integer contentId = (Integer) requestParams.get("contentId");
        Integer type = (Integer) requestParams.get("type");

        Map<String, Object> response = new HashMap<>();

        // 检查参数
        if (contentId == null || type == null) {
            response.put("code", 400);
            response.put("msg", "缺少必要参数");
            return ResponseEntity.badRequest().body(response);
        }

        // 调用 Service 层逻辑添加收藏
        boolean isAdded = starService.addCollection(contentId, type);

        if (isAdded) {
            response.put("code", 200);
            response.put("msg", "添加收藏成功");
            response.put("data", null);
        } else {
            response.put("code", 500);
            response.put("msg", "添加收藏失败");
            response.put("data", null);
        }

        return ResponseEntity.ok(response);
    }

    /**
     * 查询收藏列表
     */
    @PostMapping("/collection/list")
    @Operation(summary = "查询收藏列表")
    public ResponseEntity<Map<String, Object>> getCollectionList(@RequestBody Map<String, Object> requestParams) {
        Integer pageNum = (Integer) requestParams.get("pageNum");
        Integer pageSize = (Integer) requestParams.get("pageSize");

        Map<String, Object> response = new HashMap<>();

        if (pageNum == null || pageSize == null) {
            response.put("code", 400);
            response.put("msg", "缺少必要参数");
            return ResponseEntity.badRequest().body(response);
        }

        // 获取分页结果
        Page<StarVO> page = starService.getCollectionList(pageNum, pageSize);

        response.put("code", 200);
        response.put("msg", "查询成功");
        response.put("data", page);

        return ResponseEntity.ok(response);
    }

}

