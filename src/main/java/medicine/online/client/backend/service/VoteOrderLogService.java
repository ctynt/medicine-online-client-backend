package medicine.online.client.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.VoteOrderLog;
import medicine.online.client.backend.model.dto.VoteOrderLogDTO;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteOrderLogService
 */

public interface VoteOrderLogService extends IService<VoteOrderLog> {
    String addVote(VoteOrderLogDTO voteOrderLogDTO);
    Boolean isVote(Integer activityId);
}
