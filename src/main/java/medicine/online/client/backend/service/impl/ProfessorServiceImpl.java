package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.mapper.ProfessorMapper;
import medicine.online.client.backend.model.entity.Professor;
import medicine.online.client.backend.model.vo.ProfessorVO;
import medicine.online.client.backend.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: orange
 * @projectName: medicine-online-client-backend
 * @description:
 */
@Slf4j
@Service
@AllArgsConstructor
public class ProfessorServiceImpl extends ServiceImpl<ProfessorMapper, Professor> implements ProfessorService {
    private final ProfessorMapper professorMapper;
    @Override
    public List<ProfessorVO> getProfessorList(Integer categoryId) {
        return professorMapper.selectByCategoryId(categoryId);
    }
}
