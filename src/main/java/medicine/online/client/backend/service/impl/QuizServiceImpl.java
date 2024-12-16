package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import medicine.online.client.backend.common.result.PageResult;
import medicine.online.client.backend.mapper.QuizMapper;
import medicine.online.client.backend.model.entity.Quiz;
import medicine.online.client.backend.model.query.Query;
import medicine.online.client.backend.service.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 16:18
 * @description:
 **/
@Service
public class QuizServiceImpl extends ServiceImpl<QuizMapper, Quiz> implements QuizService {
    @Resource
    private QuizMapper quizMapper;
    @Override
    public PageResult<Quiz> getQuizList(Query query) {
        Page<Quiz> page = new Page<>(query.getPage(),query.getLimit());
        List<Quiz> list = quizMapper.getQuizList(page,query);
        return new PageResult<>(list,page.getTotal());
    }
}
