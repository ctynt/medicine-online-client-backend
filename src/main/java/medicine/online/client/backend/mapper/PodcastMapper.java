package medicine.online.client.backend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.Podcast;
import medicine.online.client.backend.model.vo.PodcastVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PodcastMapper extends BaseMapper<Podcast> {

    // 获取音频列表方法
    List<PodcastVO> ztPodcast(@Param("subjectId") Integer subjectId);
}
