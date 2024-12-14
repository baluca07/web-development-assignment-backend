package hu.unideb.web_assingnment.service;

import hu.unideb.web_assingnment.data.entities.EmployeeEntity;
import hu.unideb.web_assingnment.service.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO dto);
    EmployeeDTO updateEmployee(EmployeeDTO dto) throws Exception;
    Optional<EmployeeDTO> getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();
    void deleteEmployee(Long id);
}
