package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.cache.RequestContext;
import medicine.online.client.backend.convert.VoteActivityConvert;
import medicine.online.client.backend.mapper.VoteActivityMapper;
import medicine.online.client.backend.mapper.VoteInfoMapper;
import medicine.online.client.backend.mapper.VoteOrderLogMapper;
import medicine.online.client.backend.model.entity.VoteActivity;
import medicine.online.client.backend.model.entity.VoteInfo;
import medicine.online.client.backend.model.entity.VoteOrderLog;
import medicine.online.client.backend.model.vo.VoteActivityVO;
import medicine.online.client.backend.service.VoteActivityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteActivityServiceImpl
 */
@Slf4j
@Service
@AllArgsConstructor
public class VoteActivityServiceImpl extends ServiceImpl<VoteActivityMapper, VoteActivity> implements VoteActivityService {

    private final VoteInfoMapper voteInfoMapper;
    private final VoteOrderLogMapper voteOrderLogMapper;

    @Override
    public List<VoteActivityVO> voteActivityList() {
        List<VoteActivity> list = baseMapper.selectList();
        List<VoteActivityVO> voList = VoteActivityConvert.INSTANCE.convert(list);

        for (VoteActivityVO voteActivityVO : voList) {
            String cover = voteActivityVO.getCover();
            if (cover != null && !cover.isEmpty() && !cover.startsWith("https://")) {
                voteActivityVO.setCover("https://medicineonline.oss-cn-hangzhou.aliyuncs.com/" + cover);
            }
        }
        return voList;
    }
}
