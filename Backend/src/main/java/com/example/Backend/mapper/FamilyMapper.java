package com.example.Backend.mapper;

import com.example.Backend.dto.FamilyDTO;
import com.example.Backend.model.Family;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FamilyMapper {
    FamilyMapper INSTANCE = Mappers.getMapper(FamilyMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", expression = "java(family.getUser() != null ? family.getUser().getId() : null)")
    @Mapping(target = "memberName", source = "memberName")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "gender", expression = "java(family.getGender() != null ? family.getGender().name() : null)")
    @Mapping(target = "relationship", source = "relationship")
    FamilyDTO toDto(Family family);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "user.id", expression = "java(familyDTO.getUserId() != null ? familyDTO.getUserId() : null)")
    @Mapping(target = "memberName", source = "memberName")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "gender", expression = "java(familyDTO.getGender() != null ? Family.Gender.valueOf(familyDTO.getGender()) : null)")
    @Mapping(target = "relationship", source = "relationship")
    Family toEntity(FamilyDTO familyDTO);
}