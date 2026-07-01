package com.example.demo.repository;
import com.example.demo.dto.StudentResponseDto;
import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
    List<Student> findAllByName(String name);

    @Query("""
           Select s from Student s where s.department.name=:name
           """)
    List<Student> findByDepartmentName(@Param("name") String name);

    @Query("""
           SELECT new com.example.demo.dto.StudentResponseDto(
                     s.id,
                     s.name,
                     s.department.name
           )
           FROM Student s
          """)
          List<StudentResponseDto> findAllStudentDtos();
}
