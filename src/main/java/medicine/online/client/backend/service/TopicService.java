package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.Topic;
import medicine.online.client.backend.model.vo.TopicVO;

import java.util.List;
import java.util.Map;

/**
 * @author： Lance
 * @create： 2024/12/9
 * @Description TopicService
 **/
public interface TopicService extends IService<Topic> {
    //根据id查询教授问答列表
    List<TopicVO> getTopicList(Integer id);

    //根据id查询作答列表
    List<Map<String, Object>> getTopicReplyList(Integer id);

}
