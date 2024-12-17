package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.dto.VoteOrderLogDTO;
import medicine.online.client.backend.model.entity.VoteOrderLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteOrderLongConvert
 */
@Mapper
public interface VoteOrderLogConvert {
    VoteOrderLogConvert INSTANCE = Mappers.getMapper(VoteOrderLogConvert.class);
    VoteOrderLog convert (VoteOrderLogDTO voteOrderLogDTO);


}
