package hu.unideb.web_assingnment.service.implemented;

import hu.unideb.web_assingnment.data.entities.DepartmentEntity;
import hu.unideb.web_assingnment.data.entities.EmployeeEntity;
import hu.unideb.web_assingnment.data.repositories.DepartmentRepository;
import hu.unideb.web_assingnment.data.repositories.EmployeeRepository;
import hu.unideb.web_assingnment.service.EmployeeService;
import hu.unideb.web_assingnment.service.dto.EmployeeDTO;
import hu.unideb.web_assingnment.service.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repo;

    @Autowired
    DepartmentRepository repoDep;

    @Autowired
    EmployeeMapper mapper;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity entity = mapper.employeeDtoToEntity(employeeDTO);
        
        if (employeeDTO.getDepartmentId() != null) {
            DepartmentEntity department = repoDep.findById(employeeDTO.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            entity.setDepartmentEntity(department);
        }

        EmployeeEntity savedEntity = repo.save(entity);

        return mapper.employeeEntityToDto(savedEntity);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws Exception {
        EmployeeEntity employee = repo.findById(employeeDTO.getId())
                .orElseThrow(() -> new Exception("Employee not found with id: " + employeeDTO.getId()));

        employee.setName(employeeDTO.getName());

        EmployeeEntity updatedEmployee = repo.save(employee);

        return mapper.employeeEntityToDto(updatedEmployee);
    }

    @Override
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        Optional<EmployeeEntity> entity = repo.findById(id);
        return entity.map(mapper::employeeEntityToDto);  // Mapping the entity to DTO if present
    }


    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return mapper.employeeEntityListToDtoList(repo.findAll());
    }

    @Override
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}
