package medicine.online.client.backend.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.mapper.PodcastMapper;
import medicine.online.client.backend.model.entity.Podcast;
import medicine.online.client.backend.model.vo.PodcastVO;
import medicine.online.client.backend.service.PodcastService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PodcastServiceImpl extends ServiceImpl<PodcastMapper, Podcast> implements PodcastService {

    @Override
    public List<PodcastVO> ztPodcast(Integer subjectId) {
        return baseMapper.ztPodcast(subjectId);
    }
}
