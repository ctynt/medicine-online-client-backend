package medicine.online.client.backend.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @author WangL
 */
@Service
public class OssServiceImpl {

    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    public String uploadFile(MultipartFile file) throws IOException {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            ossClient.putObject(bucketName, fileName, file.getInputStream());
            return "http://" + bucketName + "." + endpoint + "/" + fileName;
        } finally {
            ossClient.shutdown();
        }
    }
}



