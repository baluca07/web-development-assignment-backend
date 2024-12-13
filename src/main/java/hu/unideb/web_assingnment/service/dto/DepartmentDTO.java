package hu.unideb.web_assingnment.service.dto;

public class DepartmentDTO {

    private Long id;
    private String name;

    // Constructor
    public DepartmentDTO() {}

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "DepartmentDTO{id=" + id + ", name='" + name + "'}";
    }
}
