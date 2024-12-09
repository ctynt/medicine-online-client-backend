package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.vo.ProfessorCategoryVO;
import medicine.online.client.backend.model.entity.ProfessorCategory;

import java.util.List;


public interface ProfessorCategoryService extends IService<ProfessorCategory> {
    List<ProfessorCategoryVO> listCategoryForCustomer();

}
