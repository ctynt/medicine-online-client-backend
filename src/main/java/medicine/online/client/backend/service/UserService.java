package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.dto.WxLoginDTO;
import medicine.online.client.backend.model.entity.User;
import medicine.online.client.backend.model.vo.UserLoginVO;

public interface UserService extends IService<User> {
    UserLoginVO weChatLogin(WxLoginDTO loginDTO);

    void logout();

    void bindPhone(String phone,String code,String accessToken);

    boolean checkUserEnabled(Integer userId);
}
