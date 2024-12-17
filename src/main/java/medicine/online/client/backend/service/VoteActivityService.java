package medicine.online.client.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import medicine.online.client.backend.model.entity.VoteActivity;
import medicine.online.client.backend.model.vo.VoteActivityVO;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteService
 */

public interface VoteActivityService extends IService<VoteActivity> {
    List<VoteActivityVO> voteActivityList();

}
