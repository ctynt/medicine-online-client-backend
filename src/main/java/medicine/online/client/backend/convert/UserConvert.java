package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.dto.UserEditDTO;
import medicine.online.client.backend.model.entity.User;
import medicine.online.client.backend.model.vo.UserInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    // 获取UserConvert实例，由MapStruct自动生成实现类并提供实例
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    // 将User对象转换为UserInfoVO对象
    UserInfoVO convert(User user);

    User convert(UserEditDTO dto);
}