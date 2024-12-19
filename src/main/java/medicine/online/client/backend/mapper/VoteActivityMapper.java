package medicine.online.client.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import medicine.online.client.backend.model.entity.VoteActivity;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteActivityMapper
 */

public interface VoteActivityMapper extends BaseMapper<VoteActivity> {
    default List<VoteActivity> selectList() {
        return this.selectList(new LambdaQueryWrapper<VoteActivity>().eq(VoteActivity::getType,0));
    }

}
