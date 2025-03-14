package com.example.Backend.mapper;

import com.example.Backend.dto.VaccinationDTO;
import com.example.Backend.model.Vaccination;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VaccinationMapper {
    VaccinationMapper INSTANCE = Mappers.getMapper(VaccinationMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "familyId", expression = "java(vaccination.getFamily() != null ? vaccination.getFamily().getId() : null)")
    @Mapping(target = "vaccineName", source = "vaccineName")
    @Mapping(target = "vaccinationDate", source = "vaccinationDate")
    @Mapping(target = "status", expression = "java(vaccination.getStatus() != null ? vaccination.getStatus().name() : null)")
    VaccinationDTO toDto(Vaccination vaccination);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "family.id", expression = "java(vaccinationDTO.getFamilyId() != null ? vaccinationDTO.getFamilyId() : null)")
    @Mapping(target = "vaccineName", source = "vaccineName")
    @Mapping(target = "vaccinationDate", source = "vaccinationDate")
    @Mapping(target = "status", expression = "java(vaccinationDTO.getStatus() != null ? Vaccination.Status.valueOf(vaccinationDTO.getStatus()) : null)")
    Vaccination toEntity(VaccinationDTO vaccinationDTO);
}