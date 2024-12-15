package hu.unideb.web_assingnment.service.dto;

import hu.unideb.web_assingnment.data.entities.Role;

import java.util.Objects;

public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private Role role;

    public UserDTO() {
    }

    public UserDTO(Long id, String email, String password, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(email, userDTO.email) && Objects.equals(password, userDTO.password) && role == userDTO.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, role);
    }
}
