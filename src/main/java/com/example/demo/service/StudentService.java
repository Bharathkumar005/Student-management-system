package com.example.demo.service;
import com.example.demo.dto.StudentRequestDto;
import com.example.demo.dto.StudentResponseDto;
import com.example.demo.entity.Department;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.studentSpecification.StudentSpecification;
import org.springframework.data.jpa.domain.Specification;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class StudentService {
    final private StudentRepository repository;
    final private DepartmentRepository departmentRepository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository repository, DepartmentRepository departmentRepository, StudentMapper mapper){
        this.repository=repository;
        this.departmentRepository=departmentRepository;
        this.mapper=mapper;
    }

    public StudentResponseDto dtoTemplate(Student student){
        return mapper.toResponseDto(student);
    }

    public Optional<Student> getStudentById(Integer id){
        return repository.findById(id);
    }

    public StudentResponseDto saveStudent(StudentRequestDto dto){
        Integer id= dto.getDeptId();
        Department department=departmentRepository.findById(id).orElseThrow(()->new RuntimeException("Department Not Found"));

        Student student=mapper.toEntity(dto);
        student.setDepartment(department);

        repository.save(student);

        StudentResponseDto response=dtoTemplate(student);
        return response;
    }

    public List<StudentResponseDto> getAllStudents(){
        return repository.findAllStudentDtos();
    }

    public void deleteStudent(Integer id){
        repository.deleteById(id);
    }

    public Student UpdateStudentById(Integer id, Student updatedStudent){
        Student existingStudent=repository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student with name "+id+" not found."));
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setDepartment(updatedStudent.getDepartment());

        return repository.save(existingStudent);
    }

    public Page<StudentResponseDto> getStudents(Pageable pageable){
        Page<Student> students = repository.findAll(pageable);

        return students.map(student ->
                new StudentResponseDto(
                        student.getStudentId(),
                        student.getName(),
                        student.getDepartment().getName()
                ));
    }

    public List<StudentResponseDto> searchStudents(String name,String dept){
        Specification<Student> spec = Specification.unrestricted();
        if(name!=null && !name.isBlank()){
            spec=spec.and(StudentSpecification.hasName(name));
        }
        if(dept!=null && !dept.isBlank()){
            spec=spec.and(StudentSpecification.hasDepartment(dept));
        }

        List<Student> students = repository.findAll(spec);
        List<StudentResponseDto> response=new ArrayList<>();

        for(Student student:students){
            response.add(dtoTemplate(student));
        }
        return response;
    }
}
