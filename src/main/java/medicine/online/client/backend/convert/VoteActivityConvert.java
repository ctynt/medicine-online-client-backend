package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.VoteActivity;
import medicine.online.client.backend.model.vo.VoteActivityVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/17
 * @Description VoteActivityConvert
 */
@Mapper
public interface VoteActivityConvert {
    VoteActivityConvert INSTANCE = Mappers.getMapper(VoteActivityConvert.class);
    List<VoteActivityVO> convert(List<VoteActivity> list);

}
