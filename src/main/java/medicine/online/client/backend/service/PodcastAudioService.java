package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.PodcastAudio;
import medicine.online.client.backend.model.vo.PodcastAudioVO;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/11
 * @Description PodcastAudioService
 */

public interface PodcastAudioService extends IService<PodcastAudio> {
    List<PodcastAudioVO> getPodcastDetail(Integer podcastId);
}
