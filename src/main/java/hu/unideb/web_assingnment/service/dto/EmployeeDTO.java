package hu.unideb.web_assingnment.service.dto;

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
    public String toString() {
        return "EmployeeDTO{id=" + id + ", name='" + name + "', departmentId=" + departmentId + "}";
    }
}
