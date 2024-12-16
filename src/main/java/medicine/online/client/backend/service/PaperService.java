package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.model.dto.PaperBankQuestion;
import medicine.online.client.backend.model.entity.Paper;
import medicine.online.client.backend.model.query.QuestionQuery;

/**
 * @author: minder
 * @createTime: 2024/12/15 21:00
 * @description:
 **/
public interface PaperService extends IService<Paper> {
    PageResult<PaperBankQuestion> getPaperQuestionsByExamId(QuestionQuery query);
}
