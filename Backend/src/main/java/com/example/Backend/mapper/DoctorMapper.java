package com.example.Backend.mapper;

import com.example.Backend.dto.DoctorDTO;
import com.example.Backend.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", expression = "java(doctor.getUser() != null ? doctor.getUser().getId() : null)")
    @Mapping(target = "specialty", source = "specialty")
    @Mapping(target = "hospital", source = "hospital")
    @Mapping(target = "phone", source = "phone")
    DoctorDTO toDto(Doctor doctor);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "user.id", expression = "java(doctorDTO.getUserId() != null ? doctorDTO.getUserId() : null)")
    @Mapping(target = "specialty", source = "specialty")
    @Mapping(target = "hospital", source = "hospital")
    @Mapping(target = "phone", source = "phone")
    Doctor toEntity(DoctorDTO doctorDTO);
}