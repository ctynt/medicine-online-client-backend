package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.VoteInfo;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteInfoMapper
 */

public interface VoteInfoMapper extends BaseMapper<VoteInfo> {
    default List<VoteInfo> selectListByActivityId(Integer activityId){
        return this.selectList(new LambdaQueryWrapper<VoteInfo>()
                .eq(VoteInfo::getActivityId, activityId)
                .orderByDesc(VoteInfo::getNum));
    }
}
