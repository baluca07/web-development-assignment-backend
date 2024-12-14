package hu.unideb.web_assingnment.service;


import hu.unideb.web_assingnment.service.dto.DepartmentDTO;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO department);
    DepartmentDTO updateDepartment(DepartmentDTO department) throws Exception;
    Optional<DepartmentDTO> getDepartmentById(Long id);
    List<DepartmentDTO> getAllDepartments();
    void deleteDepartment(Long id);
}
