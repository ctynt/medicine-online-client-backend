package medicine.online.client.backend.mapper;

import jakarta.annotation.Resource;
import medicine.online.client.backend.model.entity.CityCode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author ctynt
 * @Date 2024/12/2 
 * @Description CityCodeMapperTest
 */
 @SpringBootTest
    class CityCodeMapperTest {
     @Resource
     private CityCodeMapper cityCodeMapper;

    @Test
    void getByName() {
        CityCode cityCode = cityCodeMapper.getByName("栖霞区");
        assertNotNull(cityCode);
    }
}