package com.example.Backend.mapper;

import com.example.Backend.dto.TransferredRecordDTO;
import com.example.Backend.model.TransferredRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferredRecordMapper {
    TransferredRecordMapper INSTANCE = Mappers.getMapper(TransferredRecordMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "recordId", expression = "java(transferredRecord.getMedicalRecord() != null ? transferredRecord.getMedicalRecord().getId() : null)")
    @Mapping(target = "doctorId", expression = "java(transferredRecord.getDoctor() != null ? transferredRecord.getDoctor().getId() : null)")
    @Mapping(target = "status", expression = "java(transferredRecord.getStatus() != null ? transferredRecord.getStatus().name() : null)")
    @Mapping(target = "transferredAt", source = "transferredAt")
    TransferredRecordDTO toDto(TransferredRecord transferredRecord);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "medicalRecord.id", expression = "java(transferredRecordDTO.getRecordId() != null ? transferredRecordDTO.getRecordId() : null)")
    @Mapping(target = "doctor.id", expression = "java(transferredRecordDTO.getDoctorId() != null ? transferredRecordDTO.getDoctorId() : null)")
    @Mapping(target = "status", expression = "java(transferredRecordDTO.getStatus() != null ? TransferredRecord.Status.valueOf(transferredRecordDTO.getStatus()) : null)")
    @Mapping(target = "transferredAt", source = "transferredAt")
    TransferredRecord toEntity(TransferredRecordDTO transferredRecordDTO);
}