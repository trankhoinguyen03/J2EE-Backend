package com.example.Backend.mapper;

import com.example.Backend.dto.VaccinationDTO;
import com.example.Backend.model.Vaccination;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VaccinationMapper {
    VaccinationMapper INSTANCE = Mappers.getMapper(VaccinationMapper.class);

    @Mapping(target = "familyId", source = "family.id")
    @Mapping(target = "status", expression = "java(vaccination.getStatus().toString())")
    VaccinationDTO toDto(Vaccination vaccination);

    @Mapping(target = "family.id", source = "familyId")
    @Mapping(target = "status", expression = "java(Vaccination.Status.valueOf(vaccinationDTO.getStatus()))")
    Vaccination toEntity(VaccinationDTO vaccinationDTO);
}