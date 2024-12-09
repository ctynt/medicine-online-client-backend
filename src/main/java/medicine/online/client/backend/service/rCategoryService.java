package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.rCategory;
import medicine.online.client.backend.model.vo.rCategoryVO;

import java.util.List;

public interface rCategoryService extends IService<rCategory> {

    List<rCategoryVO> getrCategoryList();

    List<rCategoryVO> getrCategoryListByParentId(Long parentId);
}
