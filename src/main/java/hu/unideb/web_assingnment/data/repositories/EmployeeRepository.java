package hu.unideb.web_assingnment.data.repositories;

import hu.unideb.web_assingnment.data.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findAllByDepartment(Long department_id);

}
