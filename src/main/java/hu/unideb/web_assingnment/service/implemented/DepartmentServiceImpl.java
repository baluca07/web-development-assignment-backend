package hu.unideb.web_assingnment.service.implemented;

import hu.unideb.web_assingnment.data.entities.DepartmentEntity;
import hu.unideb.web_assingnment.data.repositories.DepartmentRepository;
import hu.unideb.web_assingnment.service.DepartmentService;
import hu.unideb.web_assingnment.service.dto.DepartmentDTO;
import hu.unideb.web_assingnment.service.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository repo;

    @Autowired
    DepartmentMapper mapper;
    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO department) {
        DepartmentEntity entity = mapper.departmentDtoToEntity(department);
        DepartmentEntity savedEntity = repo.save(entity);
        return mapper.departmentEntityToDto(savedEntity);
    }

    @Override
    public DepartmentDTO updateDepartment(DepartmentDTO departmentDTO) throws Exception {
        Optional<DepartmentEntity> existingDepartment = repo.findById(departmentDTO.getId());

        if (existingDepartment.isPresent()) {
            DepartmentEntity department = existingDepartment.get();
            department.setName(departmentDTO.getName());

            DepartmentEntity updatedDepartment = repo.save(department);

            return mapper.departmentEntityToDto(updatedDepartment);
        } else {
            throw new Exception("Department not found with id " + departmentDTO.getId());
        }
    }
    @Override
    public Optional<DepartmentDTO> getDepartmentById(Long id) {
        Optional<DepartmentEntity> entity = repo.findById(id);
        return entity.map(mapper::departmentEntityToDto);
    }


    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return mapper.departmentEntityListToDtoList(repo.findAll());
    }

    @Override
    public void deleteDepartment(Long id) {
        repo.deleteById(id);
    }
}
