package com.example.demo.mapper;

import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.dto.RegisterResponseDto;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User toEntity(RegisterRequestDto dto);

    @Mapping(target = "id",ignore = true)
    RegisterResponseDto toResponseDto(User user);
}
