package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.VoteInfo;
import medicine.online.client.backend.model.vo.VoteInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteInfoConvert
 */
@Mapper
public interface VoteInfoConvert {
    VoteInfoConvert INSTANCE = Mappers.getMapper(VoteInfoConvert.class);
    List<VoteInfoVO> convert (List<VoteInfo> list);
}
