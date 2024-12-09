package medicine.online.client.backend.convert;


import medicine.online.client.backend.model.entity.rCategory;
import medicine.online.client.backend.model.vo.rCategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface rCategoryConvert {
    rCategoryConvert INSTANCE = Mappers.getMapper(rCategoryConvert.class);
    List<rCategoryVO> convert(List<rCategory> list);
}