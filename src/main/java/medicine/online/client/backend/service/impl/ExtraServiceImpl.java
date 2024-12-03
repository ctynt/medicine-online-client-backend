package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.mapper.ExtraMapper;
import medicine.online.client.backend.model.entity.Extra;
import medicine.online.client.backend.service.ExtraService;
import org.springframework.stereotype.Service;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description ExtraServiceImpl
 */
@Slf4j
@Service
@AllArgsConstructor
public class ExtraServiceImpl extends ServiceImpl<ExtraMapper, Extra> implements ExtraService {
    @Override
    public String getContent(Integer type){
        Extra extra = baseMapper.getExtraByType(type);
        return extra.getContent();
    }
}
