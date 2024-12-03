package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.CityCode;

/**
 * @Author ctynt
 * @Date 2024/11/27
 * @Description CityCodeMapper
 */

public interface CityCodeMapper extends BaseMapper<CityCode> {
    default  CityCode getByCode(Integer code){
        return this.selectOne(new LambdaQueryWrapper<CityCode>().eq(CityCode::getCode, code));
    }

    default CityCode getByName(String name){
        return this.selectOne(new LambdaQueryWrapper<CityCode>().eq(CityCode::getName, name));
    }
}
