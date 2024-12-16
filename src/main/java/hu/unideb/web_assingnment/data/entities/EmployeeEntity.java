package hu.unideb.web_assingnment.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Optional;


@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId", referencedColumnName = "id", nullable = false)
    private DepartmentEntity departmentEntity;


    public EmployeeEntity(Long id, String name, DepartmentEntity departmentEntity) {
        this.id = id;
        this.name = name;
        this.departmentEntity = departmentEntity;
    }

    public EmployeeEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("departmentId")
    public Long getDepartmentId() {
        return departmentEntity != null ? departmentEntity.getId() : null;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity entity = (EmployeeEntity) o;
        return Objects.equals(id, entity.id) && Objects.equals(name, entity.name) && Objects.equals(departmentEntity, entity.departmentEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, departmentEntity);
    }
}
