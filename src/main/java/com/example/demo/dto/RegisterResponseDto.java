package com.example.demo.dto;

import com.example.demo.entity.Role;

public class RegisterResponseDto {
    private Integer id;
    private String username;
    private Role role;

    public Integer getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
