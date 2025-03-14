package com.example.Backend.mapper;

import com.example.Backend.dto.FamilyDTO;
import com.example.Backend.model.Family;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FamilyMapper {
    FamilyMapper INSTANCE = Mappers.getMapper(FamilyMapper.class);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "gender", expression = "java(family.getGender().toString())")
    FamilyDTO toDto(Family family);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "gender", expression = "java(Family.Gender.valueOf(familyDTO.getGender()))")
    Family toEntity(FamilyDTO familyDTO);
}