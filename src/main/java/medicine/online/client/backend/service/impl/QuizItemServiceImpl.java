package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import medicine.online.client.backend.mapper.QuizItemMapper;
import medicine.online.client.backend.model.entity.QuizItem;
import medicine.online.client.backend.model.vo.QuizItemVO;
import medicine.online.client.backend.service.QuizItemService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 17:11
 * @description:
 **/
@Service
public class QuizItemServiceImpl extends ServiceImpl<QuizItemMapper, QuizItemVO> implements QuizItemService {
    @Resource
    private QuizItemMapper quizItemMapper;

    @Override
    public List<QuizItemVO> getItemList(Integer examineId) {
        // 确保 quizItemMapper 不为 null
        if (quizItemMapper == null) {
            throw new IllegalStateException("QuizItemMapper is not initialized");
        }
        return quizItemMapper.selectQuizItemByExamineId(examineId);
    }
    }

