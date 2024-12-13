package hu.unideb.web_assingnment.service;

import hu.unideb.web_assingnment.service.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO dto);
    Optional<EmployeeDTO> getEmployeeById(Long id);
    List<EmployeeDTO> getAllEmployees();
    List<EmployeeDTO> getEmployeesByDepartment(Long departmentId);
    void deleteEmployee(Long id);
}
