package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.SubjectLabel;
import medicine.online.client.backend.model.vo.SubjectLabelVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectLabelMapper extends BaseMapper<SubjectLabel> {

    // 获取专题视频集列表
    List<SubjectLabelVO> getSubjectLabelList(@Param("subjectId") Integer subjectId);
}
