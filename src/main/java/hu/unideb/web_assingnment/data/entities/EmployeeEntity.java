package hu.unideb.web_assingnment.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Kapcsolat a departmenthez
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId", referencedColumnName = "id", nullable = false) // Foreign key kapcsolat
    private DepartmentEntity departmentEntity;

    // Konstruktor, getterek és setterek
    public EmployeeEntity() {}

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
}
