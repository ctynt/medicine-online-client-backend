package medicine.online.client.backend.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author ctynt
 * @Date 2024/12/4
 * @Description ResourceCategoryServiceTest
 */
@SpringBootTest
@Slf4j
class ResourceCategoryServiceTest {
    @Resource
    private ResourceCategoryService resourceCategoryService;

    @Test
    void getResourceCategoryTree() {
        log.info(String.valueOf(resourceCategoryService.getResourceCategoryTree()));
    }
}