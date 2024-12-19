package medicine.online.client.backend.controller;

import cn.hutool.json.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.cache.RequestContext;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.dto.StarDTO;
import medicine.online.client.backend.model.enums.StarTypeEnum;
import medicine.online.client.backend.model.query.StarQuery;
import medicine.online.client.backend.model.vo.StarVO;
import medicine.online.client.backend.service.StarService;
import medicine.online.client.backend.utils.JwtUtil;
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
    @PostMapping("/v2/list")
    @Operation(summary = "查询收藏列表")
    public ResponseEntity<Map<String, Object>> getCollectionList(HttpServletRequest request,@RequestBody StarQuery collectionQuery) {
        Map<String, Object> response = new HashMap<>();
        String token = request.getHeader("Authorization");
        JSONObject claims = JwtUtil.getJSONObject(token);
        Integer userId = claims.getInt("userId");
        try {
            // 调用 Service 层查询收藏列表
            Page<StarVO> result = starService.getCollectionList(userId,collectionQuery);

            response.put("code", 0);
            response.put("msg", "查询成功");
            response.put("data", result);
        } catch (IllegalArgumentException e) {
            response.put("code", 400);
            response.put("msg", e.getMessage());
        }

        return ResponseEntity.ok(response);
    }

    /**
     * 添加收藏
     */
    @PostMapping("/v2/add")
    @Operation(summary = "添加收藏")
    public Result<Object> addCollection(HttpServletRequest request,@RequestBody StarDTO starDTO) {



        String token = request.getHeader("Authorization");
        JSONObject claims = JwtUtil.getJSONObject(token);
        Integer userId = claims.getInt("userId");

        // 将前端传来的 type（如"video"）转换为对应的数字编码（如 2）
        Integer typeCode = StarTypeEnum.getCodeByType(starDTO.getType());
        starDTO.setType(String.valueOf(typeCode));

        starService.addCollection(userId, starDTO);
        return Result.ok();
    }

    /**
     * 删除收藏
     */
    @PostMapping("/v2/delete")
    @Operation(summary = "删除收藏")
    public Result<Object> deleteCollection(HttpServletRequest request,@RequestBody StarDTO starDTO) {
        String token = request.getHeader("Authorization");
        JSONObject claims = JwtUtil.getJSONObject(token);
        Integer userId = claims.getInt("userId");

        // 将前端传来的 type（如"video"）转换为对应的数字编码（如 2）
        Integer typeCode = StarTypeEnum.getCodeByType(starDTO.getType());
        starDTO.setType(String.valueOf(typeCode));

        starService.deleteCollection(userId, starDTO);
        return Result.ok();
    }
}



