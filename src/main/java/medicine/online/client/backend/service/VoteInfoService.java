package medicine.online.client.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.VoteInfo;
import medicine.online.client.backend.model.vo.VoteInfoVO;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteInfoService
 */

public interface VoteInfoService extends IService<VoteInfo> {
    List<VoteInfoVO> getVoteInfoList(Integer activityId);
}
