package com.example.demo.controller;
import com.example.demo.dto.StudentRequestDto;
import com.example.demo.dto.StudentResponseDto;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Student;
import java.util.*;
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;
    public StudentController(StudentService service){
        this.service=service;
    }

    @PostMapping
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> getOneStudent(@PathVariable Integer id){
        return service.getStudentById(id);
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents(){ return service.getAllStudents();}

    @DeleteMapping("/{id}")
    public String deleteOneStudent(@PathVariable Integer id){
        service.deleteStudent(id);
        return "Student with id: "+id+" is deleted.";
    }

    @PutMapping("/{id}")
    public Student updateOneStudent(@PathVariable Integer id,@RequestBody @Valid Student updatedStudent){
        return service.UpdateStudentById(id,updatedStudent);
    }

    @GetMapping("/page")
    public Page<StudentResponseDto> getStudents(Pageable pageable){
        return service.getStudents(pageable);
    }

    @GetMapping("/search")
    public List<StudentResponseDto> searchByNameOrDept(@RequestParam(required = false) String name,@RequestParam(required = false) String dept){
        return service.searchStudents(name,dept);
    }
}
