package hu.unideb.web_assingnment.controller;

import hu.unideb.web_assingnment.service.DepartmentService;
import hu.unideb.web_assingnment.service.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO updatedDepartment = null;
        try {
            updatedDepartment = departmentService.updateDepartment(departmentDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: " + e.getMessage());
        }
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@RequestParam Long id) {
        Optional<DepartmentDTO> departmentDTO = departmentService.getDepartmentById(id);
        return departmentDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteDepartment(@RequestParam Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
