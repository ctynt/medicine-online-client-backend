package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.service.CommonService;
import medicine.online.client.backend.service.ExtraService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "通用模块")
@RestController
@RequestMapping("/common")
@AllArgsConstructor
public class CommonController {
    private final CommonService commonService;
    private final ExtraService extraService;

    @PostMapping("/sendCode")
    @Operation(summary = "发送短信")
    public Result<Object> sendSms(@RequestParam("phone") String phone) {
        commonService.sendSms(phone);
        return Result.ok();
    }

    @PostMapping(value = "/upload/img")
    @Operation(summary = "图⽚上传")
    public Result<String> upload(@RequestBody MultipartFile file) {
        return Result.ok(commonService.upload(file));
    }

    @PostMapping(value = "/navigation/{type}")
    @Operation(summary = "获取系统信息")
    public Result<String> getInfo(@PathVariable Integer type) {
        return Result.ok(extraService.getContent(type));
    }
}