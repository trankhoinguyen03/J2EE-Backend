package com.example.Backend.mapper;

import com.example.Backend.dto.UserDTO;
import com.example.Backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "role", expression = "java(user.getRole().toString())")
    UserDTO toDto(User user);

    @Mapping(target = "role", expression = "java(User.Role.valueOf(userDTO.getRole()))")
    User toEntity(UserDTO userDTO);
}