package hu.unideb.web_assingnment.service.implemented;

import hu.unideb.web_assingnment.data.entities.EmployeeEntity;
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
    EmployeeMapper mapper;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity entity = mapper.employeeDtoToEntity(employeeDTO);
        EmployeeEntity savedEntity = repo.save(entity);
        return mapper.employeeEntityToDto(Optional.of(savedEntity));
    }

    @Override
    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        return Optional.ofNullable(mapper.employeeEntityToDto(repo.findById(id)));
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return mapper.employeeEntityListToDtoList(repo.findAll());
    }

    @Override
    public List<EmployeeDTO> getEmployeesByDepartment(Long departmentId) {
        return mapper.employeeEntityListToDtoList(repo.findAllByDepartment(departmentId));
    }

    @Override
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}
