package com.example.Backend.mapper;

import com.example.Backend.dto.DoctorDTO;
import com.example.Backend.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(target = "userId", source = "user.id")
    DoctorDTO toDto(Doctor doctor);

    @Mapping(target = "user.id", source = "userId")
    Doctor toEntity(DoctorDTO doctorDTO);
}