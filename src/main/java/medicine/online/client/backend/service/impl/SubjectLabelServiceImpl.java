package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.mapper.SubjectLabelMapper;
import medicine.online.client.backend.model.entity.Course;
import medicine.online.client.backend.model.entity.SubjectLabel;
import medicine.online.client.backend.model.vo.CourseVO;
import medicine.online.client.backend.model.vo.SubjectLabelVO;
import medicine.online.client.backend.service.ResourceCategoryService;
import medicine.online.client.backend.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class SubjectLabelServiceImpl extends ServiceImpl<SubjectLabelMapper, SubjectLabel> implements SubjectLabelService {

    @Override
    public List<SubjectLabelVO> getSubjectLabelList(Integer subjectId) {
        return baseMapper.getSubjectLabelList(subjectId);
    }

    private final ResourceCategoryService resourceCategoryService;


}
