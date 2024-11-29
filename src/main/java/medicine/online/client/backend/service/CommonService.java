package medicine.online.client.backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
    /**
     *
     *
     发送短信
     * @param phone
    ⼿机号
    }
     */
    void sendSms(String phone);
    /**
     *
     *
     ⽂件上传
     * @param file
    ⽂件
     * @return
    上传后的
    url
     */
    String upload(MultipartFile file);
}