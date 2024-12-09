package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.mapper.SubjectMapper;
import medicine.online.client.backend.model.entity.Subject;
import medicine.online.client.backend.model.vo.SubjectVO;
import medicine.online.client.backend.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public List<SubjectVO> getSubjectList() {
        return baseMapper.getSubjectList();
    }

    @Override
    public List<SubjectVO> getSubjectList0() {
        return baseMapper.getSubjectList0();
    }

    @Override
    public SubjectVO getSubjectDetail(Integer id) {
        return baseMapper.getSubjectDetail(id);
    }
}
