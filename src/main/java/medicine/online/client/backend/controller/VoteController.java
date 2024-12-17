package medicine.online.client.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import medicine.online.client.backend.common.result.Result;
import medicine.online.client.backend.model.dto.VoteOrderLogDTO;
import medicine.online.client.backend.model.vo.VoteActivityVO;
import medicine.online.client.backend.model.vo.VoteInfoVO;
import medicine.online.client.backend.service.VoteActivityService;
import medicine.online.client.backend.service.VoteInfoService;
import medicine.online.client.backend.service.VoteOrderLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteController
 */
@RestController
@RequestMapping("/vote")
@Tag(name = "活动模块")
@AllArgsConstructor
public class VoteController {
    private final VoteActivityService voteActivityService;
    private final VoteInfoService voteInfoService;
    private final VoteOrderLogService voteOrderLogService;

    @PostMapping("/voteList")
    @Operation(summary = "投票列表")
    public Result<List<VoteActivityVO>> voteList() {
        return Result.ok(voteActivityService.voteActivityList());
    }

    @PostMapping("/voteInfoList")
    @Operation(summary = "投票选项列表")
    public Result<List<VoteInfoVO>> voteInfoList(@RequestParam Integer activityId) {
        return Result.ok(voteInfoService.getVoteInfoList(activityId));
    }

    @PostMapping("/isVote")
    @Operation(summary = "是否已投票")
    public Result<Boolean> isVote(@RequestParam Integer activityId){
        return Result.ok(voteOrderLogService.isVote(activityId));
    }

    @PostMapping("/vote")
    @Operation(summary = "投票")
    public Result<String> vote(@RequestBody VoteOrderLogDTO voteOrderLogDTO){
        return Result.ok(voteOrderLogService.addVote(voteOrderLogDTO));
    }


}
