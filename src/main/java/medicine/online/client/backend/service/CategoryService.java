package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.Category;
import medicine.online.client.backend.model.vo.CategoryVO;

import java.util.List;

public interface CategoryService extends IService<Category> {

    List<CategoryVO> getCategoryList();

    List<CategoryVO> getCategoryListByParentId(Integer parentId);
}
