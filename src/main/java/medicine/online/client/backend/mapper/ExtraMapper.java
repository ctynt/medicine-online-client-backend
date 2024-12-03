package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.Extra;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description ExtraMapper
 */

public interface ExtraMapper extends BaseMapper<Extra> {
    default Extra getExtraByType(Integer type) {
        return this.selectOne(new LambdaQueryWrapper<Extra>().eq(Extra::getType,type));
    }
}
