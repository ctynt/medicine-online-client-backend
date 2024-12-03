package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.dto.FeedbackDTO;
import medicine.online.client.backend.model.dto.UserEditDTO;
import medicine.online.client.backend.model.vo.UserInfoVO;
import medicine.online.client.backend.service.FeedbackService;
import medicine.online.client.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "用户模块")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final FeedbackService feedbackService;

    @PostMapping("/logout")
    @Operation(summary = "登出")
    public Result<Object> logout() {
        userService.logout();
        return Result.ok();
    }

    @GetMapping("/getUserInfo")
    @Operation(summary = "查询⽤户信息")
    public Result<UserInfoVO> userInfo() {
        return Result.ok(userService.getUserInfo());
    }

    @PostMapping("update")
    @Operation(summary = "修改⽤户信息")
    public Result<UserInfoVO> update(@RequestBody UserEditDTO userEditDTO){
        return Result.ok(userService.updateInfo(userEditDTO));
    }

    @PostMapping("/feedback")
    @Operation(summary = "用户反馈")
    public Result<Object> feedback(@RequestBody FeedbackDTO feedbackDTO){
        feedbackService.save(feedbackDTO);
        return Result.ok();
    }
}