package hu.unideb.web_assingnment.service.mapper;

import hu.unideb.web_assingnment.data.entities.EmployeeEntity;
import hu.unideb.web_assingnment.service.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "departmentId", source = "departmentId")
    EmployeeDTO employeeEntityToDto(EmployeeEntity entity);
    List<EmployeeDTO> employeeEntityListToDtoList(List<EmployeeEntity> entities);

    EmployeeEntity employeeDtoToEntity(EmployeeDTO dto);
    List<EmployeeEntity> employeeDtoListToEntityList(List<EmployeeDTO> dtos);
}
