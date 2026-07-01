package com.example.demo.dto;

import com.example.demo.entity.Role;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequestDto {
        @NotBlank
        private String username;

        @NotBlank
        private String password;

        private Role role;

        public String getUsername(){
            return username;
        }

        public String getPassword(){
            return password;
        }

        public Role getRole(){
            return role;
        }

        public void setUsername(String username){
            this.username=username;
        }

        public void setPassword(String password){
            this.password=password;
        }

        public void setRole(Role role){
            this.role=role;
        }
}

