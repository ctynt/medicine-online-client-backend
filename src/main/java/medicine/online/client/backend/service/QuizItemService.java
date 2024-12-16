package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.QuizItem;
import medicine.online.client.backend.model.vo.QuizItemVO;

import java.util.List;

/**
 * @author: minder
 * @createTime: 2024/12/13 17:10
 * @description:
 **/
public interface QuizItemService extends IService<QuizItemVO> {
    List<QuizItemVO> getItemList(Integer examineId);
}
