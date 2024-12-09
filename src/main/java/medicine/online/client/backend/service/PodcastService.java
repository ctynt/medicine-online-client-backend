package medicine.online.client.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.Podcast;
import medicine.online.client.backend.model.vo.PodcastVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PodcastService extends IService<Podcast> {

    // 定义获取专题音频列表方法
    List<PodcastVO> ztPodcast(@Param("subjectId") Integer subjectId);
}
