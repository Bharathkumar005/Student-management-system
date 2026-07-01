package com.example.demo.service;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.dto.RegisterResponseDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UsernameAlreadyExistsException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(PasswordEncoder passwordEncoder,UserRepository userRepository,UserMapper userMapper,AuthenticationManager authenticationManager,JwtService jwtService){
        this.passwordEncoder=passwordEncoder;
        this.userRepository=userRepository;
        this.userMapper=userMapper;
        this.authenticationManager=authenticationManager;
        this.jwtService=jwtService;
    }

    public RegisterResponseDto register(RegisterRequestDto dto){
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }
        User user= userMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        userRepository.save(user);

        return userMapper.toResponseDto(user);
    }

    public LoginResponseDto login(LoginRequestDto dto){
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        User user=(User)authentication.getPrincipal();
        String token = jwtService.generateToken(user);

        return new LoginResponseDto(token);
    }
}
