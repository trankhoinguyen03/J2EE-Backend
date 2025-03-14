package com.example.Backend.mapper;

import com.example.Backend.dto.MedicalImageDTO;
import com.example.Backend.model.MedicalImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicalImageMapper {
    MedicalImageMapper INSTANCE = Mappers.getMapper(MedicalImageMapper.class);

    @Mapping(target = "recordId", source = "medicalRecord.id")
    MedicalImageDTO toDto(MedicalImage medicalImage);

    @Mapping(target = "medicalRecord.id", source = "recordId")
    MedicalImage toEntity(MedicalImageDTO medicalImageDTO);
}