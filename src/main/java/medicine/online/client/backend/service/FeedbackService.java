package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.dto.FeedbackDTO;
import medicine.online.client.backend.model.entity.Feedback;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description FeedbackService
 */

public interface FeedbackService extends IService<Feedback> {
    void save(FeedbackDTO feedbackDTO);
}
