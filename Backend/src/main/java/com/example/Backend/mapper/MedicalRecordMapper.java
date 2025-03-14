package com.example.Backend.mapper;

import com.example.Backend.dto.MedicalRecordDTO;
import com.example.Backend.model.MedicalRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicalRecordMapper {
    MedicalRecordMapper INSTANCE = Mappers.getMapper(MedicalRecordMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "familyId", expression = "java(medicalRecord.getFamily() != null ? medicalRecord.getFamily().getId() : null)")
    @Mapping(target = "doctorId", expression = "java(medicalRecord.getDoctor() != null ? medicalRecord.getDoctor().getId() : null)")
    @Mapping(target = "diagnosis", source = "diagnosis")
    @Mapping(target = "treatment", source = "treatment")
    @Mapping(target = "visitDate", source = "visitDate")
    MedicalRecordDTO toDto(MedicalRecord medicalRecord);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "family.id", expression = "java(medicalRecordDTO.getFamilyId() != null ? medicalRecordDTO.getFamilyId() : null)")
    @Mapping(target = "doctor.id", expression = "java(medicalRecordDTO.getDoctorId() != null ? medicalRecordDTO.getDoctorId() : null)")
    @Mapping(target = "diagnosis", source = "diagnosis")
    @Mapping(target = "treatment", source = "treatment")
    @Mapping(target = "visitDate", source = "visitDate")
    MedicalRecord toEntity(MedicalRecordDTO medicalRecordDTO);
}