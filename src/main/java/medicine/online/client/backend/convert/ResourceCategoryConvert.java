package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.ResourceCategory;
import medicine.online.client.backend.model.vo.ResourceCategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Author ctynt
 * @Date 2024/12/4
 * @Description ResourceCategoryConvert
 */
@Mapper
public interface ResourceCategoryConvert {
    ResourceCategoryConvert INSTANCE = Mappers.getMapper(ResourceCategoryConvert.class);
    List<ResourceCategoryVO> convertToList(List<ResourceCategory> list);
    ResourceCategoryVO toVO(ResourceCategory category);
    ResourceCategory voTo(ResourceCategoryVO vo);
}
