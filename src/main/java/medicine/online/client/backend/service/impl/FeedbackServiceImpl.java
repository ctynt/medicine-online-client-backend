package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.cache.RequestContext;
import medicine.online.client.backend.common.exception.ServerException;
import medicine.online.client.backend.convert.FeedbackConvert;
import medicine.online.client.backend.mapper.FeedbackMapper;
import medicine.online.client.backend.model.dto.FeedbackDTO;
import medicine.online.client.backend.model.entity.Feedback;
import medicine.online.client.backend.service.FeedbackService;
import org.springframework.stereotype.Service;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description FeedbackServiceImpl
 */
@Slf4j
@Service
@AllArgsConstructor
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {
    @Override
    public void save(FeedbackDTO feedbackDTO){
        Integer userId = RequestContext.getUserId();
        feedbackDTO.setUserId(userId);
        if (feedbackDTO.getImg()==null){
            feedbackDTO.setImg("null");
        }
        try {
            if (baseMapper.insert(FeedbackConvert.INSTANCE.convert(feedbackDTO)) < 1 ){
                throw new ServerException("提交反馈失败");
            }
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }

    }
}
