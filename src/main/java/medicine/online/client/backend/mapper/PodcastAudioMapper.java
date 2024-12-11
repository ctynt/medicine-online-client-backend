package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.PodcastAudio;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/11
 * @Description PodcastAudioMapper
 */

public interface PodcastAudioMapper extends BaseMapper<PodcastAudio> {
    default List<PodcastAudio> getPodcastAudioById(Integer podcastId){
        return this.selectList(new LambdaQueryWrapper<PodcastAudio>()
                .eq(PodcastAudio::getPodcastId,podcastId)
                .orderByAsc(PodcastAudio::getSort));
    }
}
