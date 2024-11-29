package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.dto.WxLoginDTO;
import medicine.online.client.backend.model.vo.UserLoginVO;
import medicine.online.client.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @Author ctynt
 * @Date 2024/11/29
 * @Description AuthController
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "认证模块")
@AllArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/login")
    @Operation(summary = "微信登录")
    public Result<UserLoginVO> weChatLogin(@RequestBody WxLoginDTO dto) {
        return Result.ok(userService.weChatLogin(dto));
    }


    @PostMapping("/bindPhone")
    @Operation(summary = "绑定手机号")
    public Result<String> bindPhone(@RequestParam("phone")String phone,
                                    @RequestParam("code")String code,
                                    @RequestHeader("Authorization")String accessToken) {
        userService.bindPhone(phone, code, accessToken);
        return Result.ok();
    }

}
