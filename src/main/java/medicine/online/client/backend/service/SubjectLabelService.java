package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.SubjectLabel;
import medicine.online.client.backend.model.vo.SubjectLabelVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectLabelService extends IService<SubjectLabel> {

    // 专题视频集
    List<SubjectLabelVO> getSubjectLabelList(@Param("subjectId") Integer subjectId);

}
