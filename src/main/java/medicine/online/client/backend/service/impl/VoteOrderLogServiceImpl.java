package medicine.online.client.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import medicine.online.client.backend.common.cache.RequestContext;
import medicine.online.client.backend.convert.VoteOrderLogConvert;
import medicine.online.client.backend.mapper.VoteActivityMapper;
import medicine.online.client.backend.mapper.VoteInfoMapper;
import medicine.online.client.backend.mapper.VoteOrderLogMapper;
import medicine.online.client.backend.model.entity.VoteActivity;
import medicine.online.client.backend.model.entity.VoteInfo;
import medicine.online.client.backend.model.entity.VoteOrderLog;
import medicine.online.client.backend.model.dto.VoteOrderLogDTO;
import medicine.online.client.backend.service.VoteOrderLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteOrderLogServiceImpl
 */
@Slf4j
@Service
@AllArgsConstructor
public class VoteOrderLogServiceImpl extends ServiceImpl<VoteOrderLogMapper, VoteOrderLog> implements VoteOrderLogService {
    private final VoteInfoMapper voteInfoMapper;
    private final VoteActivityMapper voteActivityMapper;
    @Override
    public String addVote(VoteOrderLogDTO voteOrderLogDTO) {
        Integer userId = RequestContext.getUserId();
        VoteOrderLog voteOrderLog = VoteOrderLogConvert.INSTANCE.convert(voteOrderLogDTO);
        voteOrderLog.setUserId(userId);
        baseMapper.insert(voteOrderLog);
        VoteInfo voteInfo = voteInfoMapper.selectById(voteOrderLogDTO.getInfoId());
        voteInfo.setNum(voteInfo.getNum() + 1);
        voteInfoMapper.updateById(voteInfo);
        VoteActivity voteActivity = voteActivityMapper.selectById(voteOrderLogDTO.getActivityId());
        voteActivity.setParticipation(voteActivity.getParticipation() + 1);
        voteActivityMapper.updateById(voteActivity);

        List<VoteInfo> voteInfoList = voteInfoMapper.selectListByActivityId(voteOrderLogDTO.getActivityId());
        int totalVotes = voteInfoList.stream().mapToInt(VoteInfo::getNum).sum();
        for (VoteInfo info : voteInfoList) {
            // 避免除零错误，totalVotes 需要大于零
            double proportion = totalVotes > 0 ? (double) info.getNum() / totalVotes : 0.0;
            info.setProportion(proportion);
            voteInfoMapper.updateById(info);
        }
        return "投票成功";
    }

    @Override
    public Boolean isVote(Integer activityId){
        Integer userId = RequestContext.getUserId();
        return baseMapper.selectByUserId(userId,activityId) == null;
    }
}
