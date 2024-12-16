package medicine.online.client.backend.convert;

import medicine.online.client.backend.model.entity.Subject;
import medicine.online.client.backend.model.vo.SubjectVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectConvert {
    SubjectConvert INSTANCE = Mappers.getMapper(SubjectConvert.class);
    List<SubjectVO> convert(List<Subject> list);
}
