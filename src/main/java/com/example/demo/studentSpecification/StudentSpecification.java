package com.example.demo.studentSpecification;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {
    public static Specification<Student> hasName(String name){
        return (root,query,criteriaBuilder)->criteriaBuilder.equal(root.get("name"),name);
    }
    public static Specification<Student> hasDepartment(String dept){
        return (root,query,cb)->cb.equal(root.get("department").get("name"),dept);
    }
}
