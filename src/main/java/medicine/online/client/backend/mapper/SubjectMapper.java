package medicine.online.client.backend.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import medicine.online.client.backend.model.entity.Subject;
import medicine.online.client.backend.model.vo.SubjectVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectMapper extends BaseMapper<Subject> {

    // 获取专题列表方法
    List<SubjectVO> getSubjectList();

    // 获取专题列表方法
    List<SubjectVO> getSubjectList0();

    // 获取专题列表详情方法
    SubjectVO getSubjectDetail(Integer id);

    // 根据title模糊查询
    Page<SubjectVO> getSubjectByTitleLike(@Param("title") String title, Page<SubjectVO> page, QueryWrapper<SubjectVO> queryWrapper);

    // 新增方法用于判断pk_id是否存在于t_index_content表中
    boolean isSubjectPkIdExist(Integer pkId);
}
