package hu.unideb.web_assingnment.data;

import hu.unideb.web_assingnment.data.entities.DepartmentEntity;
import hu.unideb.web_assingnment.data.entities.EmployeeEntity;
import hu.unideb.web_assingnment.data.entities.Role;
import hu.unideb.web_assingnment.data.entities.UserEntity;
import hu.unideb.web_assingnment.data.repositories.DepartmentRepository;
import hu.unideb.web_assingnment.data.repositories.EmployeeRepository;
import hu.unideb.web_assingnment.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args){
        if (userRepository.count() == 0) {
            String encodedPassword = passwordEncoder.encode("admin");
            UserEntity admin = new UserEntity(null, "admin@admin.com", encodedPassword, Role.ADMIN);
            userRepository.save(admin);
            System.out.println("Admin user created: admin@admin.com");
        }

        if (userRepository.count() == 1) {
            String encodedPassword = passwordEncoder.encode("user");
            UserEntity user = new UserEntity(null, "user@user.com", encodedPassword, Role.USER);
            userRepository.save(user);
            System.out.println("User created: user@user.com");
        }

        if (departmentRepository.count() == 0) {
            DepartmentEntity department1 = new DepartmentEntity(null,"HR",null);
            DepartmentEntity department2 = new DepartmentEntity(null, "IT",null);
            departmentRepository.save(department1);
            departmentRepository.save(department2);
            System.out.println("Departments created: HR, IT");
            if (employeeRepository.count() == 0) {
                EmployeeEntity employee1 = new EmployeeEntity(null, "Mr. Paperwork",department1);
                EmployeeEntity employee2 = new EmployeeEntity(null, "Sir Fix-a-Lot",department2);
                employeeRepository.save(employee1);
                employeeRepository.save(employee2);
                System.out.println("Employees created: Motiv Ottó, Bit Edit");
            }
        }
    }
}
