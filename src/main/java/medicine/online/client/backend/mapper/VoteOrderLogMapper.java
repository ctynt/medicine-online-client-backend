package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.VoteOrderLog;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteOrderLogMapper
 */

public interface VoteOrderLogMapper extends BaseMapper<VoteOrderLog> {
    default VoteOrderLog selectByUserId(Integer userId,Integer activityId){
        return this.selectOne(new LambdaQueryWrapper<VoteOrderLog>()
                .eq(VoteOrderLog::getUserId, userId)
                .eq(VoteOrderLog::getActivityId, activityId)
        );
    }
}
