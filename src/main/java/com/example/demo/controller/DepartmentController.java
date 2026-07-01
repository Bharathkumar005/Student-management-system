package com.example.demo.controller;
import java.util.*;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service){
        this.service=service;
    }

    @GetMapping
    public List<Department> getAllDepartments(){ return service.getAllDepartments();}

    @PostMapping
    public Department saveDepartment(@RequestBody @Valid Department department){ return service.saveDepartment(department);}

    @DeleteMapping("/{name}")
    public String deleteDepartment(@PathVariable String name){
        service.DeleteDept(name);
        return "Department with name "+name+" deleted";
    }

    @GetMapping("/{name}")
    public Optional<Department> getByName(@PathVariable String name){ return service.getDeptByName(name); }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Integer id,@RequestBody @Valid Department updatedDept){
        return service.updateDept(id,updatedDept);
    }


}
