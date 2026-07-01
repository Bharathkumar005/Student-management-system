package com.example.demo.mapper;

import com.example.demo.dto.StudentRequestDto;
import com.example.demo.dto.StudentResponseDto;
import com.example.demo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "studentId", target = "id")
    @Mapping(
            source = "department.name",
            target = "department"
    )
    StudentResponseDto toResponseDto (Student student);

    @Mapping(target="studentId",ignore = true)
    @Mapping(target = "department",ignore = true)
    Student toEntity (StudentRequestDto dto);
}
