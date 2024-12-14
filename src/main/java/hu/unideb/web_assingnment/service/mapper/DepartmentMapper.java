package hu.unideb.web_assingnment.service.mapper;

import hu.unideb.web_assingnment.data.entities.DepartmentEntity;
import hu.unideb.web_assingnment.service.dto.DepartmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "id", source = "id")
    DepartmentDTO departmentEntityToDto(DepartmentEntity entity);
    List<DepartmentDTO> departmentEntityListToDtoList(List<DepartmentEntity> entities);

    DepartmentEntity departmentDtoToEntity(DepartmentDTO dto);

}
