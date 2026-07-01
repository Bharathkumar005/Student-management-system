package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.exception.DepartmentNotFoundException;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class DepartmentService {
    public DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository){
        this.repository=repository;
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    public Department saveDepartment(Department department){
        return repository.save(department);
    }

    public List<Department> getAllDepartments(){
        return repository.findAll();
    }

    public Optional<Department> getDeptByName(String name){
        return repository.findByName(name);
    }

    @Transactional
    @PreAuthorize("hasAuthority('ADMIN')")
    public void DeleteDept(String name){ repository.deleteByName(name); }

    @PreAuthorize("hasAuthority('ADMIN')")
    public Department updateDept(Integer id,Department updatedDept){
        Department existingDept=repository.findById(id).orElseThrow(()-> new DepartmentNotFoundException("Department Not found"));
        existingDept.setName(updatedDept.getName());
        return repository.save(existingDept);
    }
}
