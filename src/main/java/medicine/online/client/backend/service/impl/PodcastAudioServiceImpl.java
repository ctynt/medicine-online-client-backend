package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.convert.PodcastAudioConvert;
import medicine.online.client.backend.mapper.PodcastAudioMapper;
import medicine.online.client.backend.model.entity.PodcastAudio;
import medicine.online.client.backend.model.vo.PodcastAudioVO;
import medicine.online.client.backend.model.vo.PodcastVO;
import medicine.online.client.backend.service.PodcastAudioService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/11
 * @Description PodcastAudioServiceImpl
 */
@Slf4j
@Service
@AllArgsConstructor
public class PodcastAudioServiceImpl extends ServiceImpl<PodcastAudioMapper, PodcastAudio> implements PodcastAudioService {
    @Override
    public List<PodcastAudioVO> getPodcastDetail(Integer podcastId) {
        List<PodcastAudio> podcasts = baseMapper.getPodcastAudioById(podcastId);
        List<PodcastAudioVO> list = PodcastAudioConvert.INSTANCE.convert(podcasts);

        for (PodcastAudioVO podcastAudioVO : list) {
            String url = podcastAudioVO.getUrl();
            // 如果 URL 没有 https 前缀，则添加 https://
            if ( url != null && !url.isEmpty() && !url.startsWith("https://")) {
                podcastAudioVO.setUrl("https://medicineonline.oss-cn-hangzhou.aliyuncs.com/" + url);
            }
        }

        return list;
    }

}
