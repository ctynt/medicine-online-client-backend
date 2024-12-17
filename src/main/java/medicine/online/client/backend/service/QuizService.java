package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.model.entity.Quiz;
import medicine.online.client.backend.model.query.Query;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 16:17
 * @description:
 **/
public interface QuizService extends IService<Quiz> {
    PageResult<Quiz> getQuizList(Query query);
}
