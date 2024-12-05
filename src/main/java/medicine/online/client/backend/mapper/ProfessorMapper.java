package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.client.backend.model.entity.Professor;
import medicine.online.client.backend.model.query.ProfessorQuery;
import medicine.online.client.backend.model.vo.ProfessorVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
public interface ProfessorMapper extends BaseMapper<Professor> {
    List<ProfessorVO> getProfessorPage(Page<ProfessorVO> page, @Param("query")ProfessorQuery query);
}
