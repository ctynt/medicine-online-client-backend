package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.Professor;
import medicine.online.client.backend.model.vo.ProfessorVO;

import java.util.List;

public interface ProfessorService extends IService<Professor> {
    List<ProfessorVO> getProfessorList(Integer categoryId);
}
