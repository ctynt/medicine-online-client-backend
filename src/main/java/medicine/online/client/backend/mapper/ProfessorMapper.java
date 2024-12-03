package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.Professor;
import medicine.online.client.backend.model.vo.ProfessorVO;

import java.util.List;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
public interface ProfessorMapper extends BaseMapper<Professor> {
    List<ProfessorVO> selectByCategoryId(Integer categoryId);
}
