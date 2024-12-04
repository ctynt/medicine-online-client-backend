package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.Extra;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description ExtraService
 */

public interface ExtraService extends IService<Extra> {
    String getContent (Integer type);
}
