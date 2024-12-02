package medicine.online.client.backend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.Subject;
import medicine.online.client.backend.model.vo.SubjectVO;

import java.util.List;

public interface SubjectMapper extends BaseMapper<Subject> {

    // 获取专题列表方法
    List<SubjectVO> getSubjectList();

    // 获取专题列表详情方法
    SubjectVO getSubjectDetail(Integer id);
}
