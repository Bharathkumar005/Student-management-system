package com.example.demo.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.util.*;
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Department Name cannot be blank")
    private String name;

    public Department(){}

    @OneToMany(mappedBy = "department",
     cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Student> students = new ArrayList<>();


    public Integer getId(){return id;}

    public void setId(Integer id){ this.id=id;}

    public String getName(){return name;}

    public void setName(String name){this.name=name;}

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
