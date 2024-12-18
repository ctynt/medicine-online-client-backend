package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.dto.StarDTO;
import medicine.online.client.backend.model.entity.Star;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author： Lance
 * @create： 2024/12/18
 * @Description StarConvert
 **/
@Mapper
public interface StarConvert {
    StarConvert INSTANCE = Mappers.getMapper(StarConvert.class);
    Star convert(StarDTO starDTO);
}