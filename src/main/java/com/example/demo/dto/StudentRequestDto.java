package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentRequestDto {

    @NotBlank(message = "Name blank Cannot be null")
    private String name;

    @NotNull(message = "Department Blank cannot be null")
    private Integer deptId;

    public StudentRequestDto(){}

    public String getName(){
        return name;
    }

    public Integer getDeptId(){
        return deptId;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setDeptId(Integer deptId){
        this.deptId=deptId;
    }
}
