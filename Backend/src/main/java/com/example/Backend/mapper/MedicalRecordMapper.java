package com.example.Backend.mapper;

import com.example.Backend.dto.MedicalRecordDTO;
import com.example.Backend.model.MedicalRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicalRecordMapper {
    MedicalRecordMapper INSTANCE = Mappers.getMapper(MedicalRecordMapper.class);

    @Mapping(target = "familyId", source = "family.id")
    @Mapping(target = "doctorId", source = "doctor.id")
    MedicalRecordDTO toDto(MedicalRecord medicalRecord);

    @Mapping(target = "family.id", source = "familyId")
    @Mapping(target = "doctor.id", source = "doctorId")
    MedicalRecord toEntity(MedicalRecordDTO medicalRecordDTO);
}