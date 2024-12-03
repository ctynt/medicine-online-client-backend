package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.service.CollectionService;
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
@RequestMapping("/collection")
@Tag(name = "收藏模块")
@AllArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    @PostMapping("/delete")
    public ResponseEntity<Map<String, Object>> deleteCollection(@RequestBody Map<String, Object> requestParams) {
        Integer contentId = (Integer) requestParams.get("contentId");
        Integer type = (Integer) requestParams.get("type");

        Map<String, Object> response = new HashMap<>();

        if (contentId == null || type == null) {
            response.put("code", 400);
            response.put("msg", "缺少必要参数");
            return ResponseEntity.badRequest().body(response);
        }

        boolean isDeleted = collectionService.deleteCollection(contentId, type);

        if (isDeleted) {
            response.put("code", 200);
            response.put("msg", "删除收藏成功");
            response.put("data", null);  // 删除操作成功后可以返回空数据
        } else {
            response.put("code", 500);
            response.put("msg", "删除收藏失败");
            response.put("data", null);
        }

        return ResponseEntity.ok(response);
    }
}

