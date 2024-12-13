package hu.unideb.web_assingnment.service.mapper;

import hu.unideb.web_assingnment.data.entities.DepartmentEntity;
import hu.unideb.web_assingnment.service.dto.DepartmentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "id", source = "id")
    DepartmentDTO employeeEntityToDto(DepartmentEntity entity);
    List<DepartmentDTO> employeeEntityListToDtoList(List<DepartmentEntity> entities);

    DepartmentEntity employeeDtoToEntity(DepartmentDTO dto);
    List<DepartmentEntity> employeeDtoListToEntityList(List<DepartmentDTO> dtos);
}
