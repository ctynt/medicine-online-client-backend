package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "测试接口")
@RestController
public class TestController {

    @GetMapping("/test")
    @Operation(summary = "测试接口")
    public String test() {
        return "Hello MedicineApp !";
    }
}

