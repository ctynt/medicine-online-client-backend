package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.mapper.BankMapper;
import medicine.online.client.backend.mapper.PaperMapper;
import medicine.online.client.backend.model.dto.PaperBankQuestion;
import medicine.online.client.backend.model.entity.Paper;
import medicine.online.client.backend.model.query.QuestionQuery;
import medicine.online.client.backend.service.PaperService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/15 21:01
 * @description:
 **/
@Service
@AllArgsConstructor
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {
    @Resource
    private PaperMapper paperMapper;
    @Resource
    private BankMapper bankMapper;

   @Override
    public PageResult<PaperBankQuestion> getPaperQuestionsByPaperId(QuestionQuery query) {
        Page<PaperBankQuestion> page = new Page<>(query.getPage(), query.getLimit());
        List<PaperBankQuestion> questions = baseMapper.getPaperQuestions(page, query.getPaperId());
        
        return new PageResult<>(questions, page.getTotal());
    }
}
