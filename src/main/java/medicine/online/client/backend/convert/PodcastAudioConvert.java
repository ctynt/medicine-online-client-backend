package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.PodcastAudio;
import medicine.online.client.backend.model.vo.PodcastAudioVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/11
 * @Description PodcastAudioConvert
 */
@Mapper
public interface PodcastAudioConvert {
    PodcastAudioConvert INSTANCE = Mappers.getMapper(PodcastAudioConvert.class);
    List<PodcastAudioVO> convert(List<PodcastAudio> podcastAudio);
}
