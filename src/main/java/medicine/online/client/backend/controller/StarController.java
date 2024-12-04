package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.model.dto.StarDTO;
import medicine.online.client.backend.model.query.StarQuery;
import medicine.online.client.backend.model.vo.StarVO;
import medicine.online.client.backend.service.StarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangL
 * @description 收藏模块 Controller 层
 */
@RestController
@RequestMapping("/star")
@Tag(name = "收藏模块")
@AllArgsConstructor
public class StarController {

    private final StarService starService;

    /**
     * 查询收藏列表
     */
    @PostMapping("/list")
    @Operation(summary = "查询收藏列表")
    public ResponseEntity<Map<String, Object>> getCollectionList(@RequestBody StarQuery collectionQuery) {
        Map<String, Object> response = new HashMap<>();

        // 调用 Service 层查询收藏列表
        Page<StarVO> result = starService.getCollectionList(collectionQuery);

        response.put("code", 200);
        response.put("msg", "查询成功");
        response.put("data", result);

        return ResponseEntity.ok(response);
    }

    /**
     * 添加收藏
     */
    @PostMapping("/add")
    @Operation(summary = "添加收藏")
    public ResponseEntity<Map<String, Object>> addCollection(@RequestBody StarDTO starDTO) {
        Map<String, Object> response = new HashMap<>();

        // 调用 Service 层添加收藏
        boolean success = starService.addCollection(starDTO);

        if (success) {
            response.put("code", 200);
            response.put("msg", "添加收藏成功");
        } else {
            response.put("code", 500);
            response.put("msg", "添加收藏失败");
        }

        return ResponseEntity.ok(response);
    }

    /**
     * 删除收藏
     */
    @PostMapping("/delete")
    @Operation(summary = "删除收藏")
    public ResponseEntity<Map<String, Object>> deleteCollection(@RequestBody StarDTO starDTO) {
        Map<String, Object> response = new HashMap<>();

        // 调用 Service 层删除收藏
        boolean success = starService.deleteCollection(starDTO);

        if (success) {
            response.put("code", 200);
            response.put("msg", "删除收藏成功");
        } else {
            response.put("code", 500);
            response.put("msg", "删除收藏失败");
        }

        return ResponseEntity.ok(response);
    }
}
