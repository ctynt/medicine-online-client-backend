package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.cache.RequestContext;
import medicine.online.client.backend.convert.VoteInfoConvert;
import medicine.online.client.backend.mapper.VoteInfoMapper;
import medicine.online.client.backend.model.entity.VoteInfo;
import medicine.online.client.backend.model.entity.VoteOrderLog;
import medicine.online.client.backend.model.vo.VoteInfoVO;
import medicine.online.client.backend.service.VoteInfoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteInfoServiceImpl
 */
@Slf4j
@Service
@AllArgsConstructor
public class VoteInfoServiceImpl extends ServiceImpl<VoteInfoMapper, VoteInfo> implements VoteInfoService {
    @Override
    public List<VoteInfoVO> getVoteInfoList(Integer activityId) {
        List<VoteInfo> list = baseMapper.selectListByActivityId(activityId);
        List<VoteInfoVO> voList = VoteInfoConvert.INSTANCE.convert(list);
        for (VoteInfoVO vo : voList) {
            String cover = vo.getCover();
            if (cover != null && !cover.isEmpty() && !cover.startsWith("https://")) {
                vo.setCover("https://medicineonline.oss-cn-hangzhou.aliyuncs.com/" + cover);
            }
        }
        return voList;
    }
}
