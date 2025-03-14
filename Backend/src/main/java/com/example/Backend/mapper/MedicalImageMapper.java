package com.example.Backend.mapper;

import com.example.Backend.dto.MedicalImageDTO;
import com.example.Backend.model.MedicalImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicalImageMapper {
    MedicalImageMapper INSTANCE = Mappers.getMapper(MedicalImageMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "recordId", expression = "java(medicalImage.getMedicalRecord() != null ? medicalImage.getMedicalRecord().getId() : null)")
    @Mapping(target = "imageUrl", source = "imageUrl")
    @Mapping(target = "description", source = "description")
    MedicalImageDTO toDto(MedicalImage medicalImage);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "medicalRecord", ignore = true) // MedicalRecord sẽ được set từ Service
    @Mapping(target = "imageUrl", source = "imageUrl")
    @Mapping(target = "description", source = "description")
    MedicalImage toEntity(MedicalImageDTO medicalImageDTO);
}