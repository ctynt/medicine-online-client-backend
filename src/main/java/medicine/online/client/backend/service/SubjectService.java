package medicine.online.client.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.Subject;
import medicine.online.client.backend.model.vo.SubjectVO;

import java.util.List;

public interface SubjectService extends IService<Subject> {

    // 定义获取专题列表方法
    List<SubjectVO> getSubjectList();

    // 专题列表详情方法
    SubjectVO getSubjectDetail(Integer id);
}
