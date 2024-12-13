package hu.unideb.web_assingnment.data.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Kapcsolat az alkalmazottakkal (egy osztálynak több alkalmazottja lehet)
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<EmployeeEntity> employees;

    // Konstruktor, getterek és setterek
    public DepartmentEntity() {}

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

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
