package com.example.demo.repository;
import java.util.*;
import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Optional<Department> findByName(String name);
    void deleteByName(String name);
}
