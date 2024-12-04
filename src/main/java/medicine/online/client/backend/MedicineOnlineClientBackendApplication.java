package medicine.online.client.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "medicine.online.client.backend.mapper")
public class MedicineOnlineClientBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicineOnlineClientBackendApplication.class, args);
    }

}
