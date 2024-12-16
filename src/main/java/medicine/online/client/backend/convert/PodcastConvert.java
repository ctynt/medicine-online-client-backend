package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.Podcast;
import medicine.online.client.backend.model.vo.PodcastVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/10
 * @Description PodcastConvert
 */
@Mapper
public interface PodcastConvert {
    PodcastConvert INSTANCE = Mappers.getMapper(PodcastConvert.class);
    List<PodcastVO> convert(List<Podcast> podcastList);
    PodcastVO convert(Podcast podcast);
}
