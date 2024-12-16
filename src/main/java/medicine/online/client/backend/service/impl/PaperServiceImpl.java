package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.mapper.PaperMapper;
import medicine.online.client.backend.model.dto.PaperBankQuestion;
import medicine.online.client.backend.model.entity.Paper;
import medicine.online.client.backend.model.query.QuestionQuery;
import medicine.online.client.backend.service.PaperService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/15 21:01
 * @description:
 **/
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {
    @Resource
    private PaperMapper paperMapper;
    @Override
    public PageResult<PaperBankQuestion> getPaperQuestionsByExamId(QuestionQuery query) {
        Page<PaperBankQuestion> page = new Page<>(query.getPage(), query.getLimit());
        List<PaperBankQuestion> list = paperMapper.selectPagedQuestions(page,query);
        return new PageResult<>(list, page.getTotal());

    }
}
