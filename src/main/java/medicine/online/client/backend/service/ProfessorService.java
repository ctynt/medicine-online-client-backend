package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.Professor;
import medicine.online.client.backend.model.vo.ProfessorDetailVO;
import medicine.online.client.backend.model.vo.ProfessorVO;

import java.util.List;

public interface ProfessorService extends IService<Professor> {
    List<ProfessorVO> getProfessorList(Integer categoryId);

    //根据id查询教授详情
    ProfessorDetailVO getProfessorDetail(Integer id);
}
