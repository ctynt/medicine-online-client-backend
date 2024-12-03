package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.dto.FeedbackDTO;
import medicine.online.client.backend.model.entity.Feedback;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author ctynt
 * @Date 2024/12/3
 * @Description FeedbackConvert
 */
@Mapper
public interface FeedbackConvert {
    FeedbackConvert INSTANCE = Mappers.getMapper(FeedbackConvert.class);
    Feedback convert(FeedbackDTO feedbackDTO);
}
