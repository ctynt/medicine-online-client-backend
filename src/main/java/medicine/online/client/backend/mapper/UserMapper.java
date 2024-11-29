package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.User;

public interface UserMapper extends BaseMapper<User> {

    default User getByPhone(String phone) {
        return this.selectOne(new LambdaQueryWrapper<User>().eq(User::getPhone, phone));
    }

    default User getByWxOpenId(String openId) {
        return this.selectOne(new LambdaQueryWrapper<User>().eq(User::getOpenId, openId));
    }
}

