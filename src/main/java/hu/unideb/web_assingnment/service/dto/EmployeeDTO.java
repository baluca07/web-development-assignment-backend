package hu.unideb.web_assingnment.service.dto;

import java.util.Objects;

public class EmployeeDTO {

    private Long id;
    private String name;
    private Long departmentId;

    // Constructor
    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String name, Long departmentId) {
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
    }

    // Getters and Setters
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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, departmentId);
    }
}
