package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "用户模块")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/logout")
    @Operation(summary = "登出")
    public Result<Object> logout() {
        userService.logout();
        return Result.ok();
    }

}