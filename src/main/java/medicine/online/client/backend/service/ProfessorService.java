package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.model.entity.Professor;
import medicine.online.client.backend.model.query.ProfessorQuery;
import medicine.online.client.backend.model.vo.ProfessorDetailVO;
import medicine.online.client.backend.model.vo.ProfessorVO;

import java.util.List;

public interface ProfessorService extends IService<Professor> {
    //根据目录id查询并分页
    PageResult<ProfessorVO> getProfessorList(ProfessorQuery query);

    //根据id查询教授详情
    ProfessorDetailVO getProfessorDetail(Integer id);
}
