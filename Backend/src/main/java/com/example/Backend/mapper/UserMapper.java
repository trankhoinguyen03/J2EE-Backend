package com.example.Backend.mapper;

import com.example.Backend.dto.UserDTO;
import com.example.Backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "role", expression = "java(user.getRole() != null ? user.getRole().name() : null)")
    @Mapping(target = "createdAt", source = "createdAt")
    UserDTO toDto(User user);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "role", expression = "java(userDTO.getRole() != null ? User.Role.valueOf(userDTO.getRole()) : null)")
    @Mapping(target = "createdAt", source = "createdAt")
    User toEntity(UserDTO userDTO);
}