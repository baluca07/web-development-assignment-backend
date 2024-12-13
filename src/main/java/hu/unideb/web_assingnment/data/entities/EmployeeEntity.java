package hu.unideb.web_assingnment.data.entities;

import jakarta.persistence.*;


@Entity
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Kapcsolat a departmenthez
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
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

    public DepartmentEntity getDepartment() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }
}
