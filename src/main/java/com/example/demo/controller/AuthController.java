package com.example.demo.controller;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.dto.RegisterResponseDto;
import com.example.demo.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service){
        this.service=service;
    }
    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(
            @Valid @RequestBody RegisterRequestDto dto) {

        RegisterResponseDto response = service.register(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto dto){
        return service.login(dto);
    }
}
