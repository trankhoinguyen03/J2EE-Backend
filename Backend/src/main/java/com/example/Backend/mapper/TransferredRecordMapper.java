package com.example.Backend.mapper;

import com.example.Backend.dto.TransferredRecordDTO;
import com.example.Backend.model.TransferredRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransferredRecordMapper {
    TransferredRecordMapper INSTANCE = Mappers.getMapper(TransferredRecordMapper.class);

    @Mapping(target = "recordId", source = "medicalRecord.id")
    @Mapping(target = "doctorId", source = "doctor.id")
    @Mapping(target = "status", expression = "java(transferredRecord.getStatus().toString())")
    TransferredRecordDTO toDto(TransferredRecord transferredRecord);

    @Mapping(target = "medicalRecord.id", source = "recordId")
    @Mapping(target = "doctor.id", source = "doctorId")
    @Mapping(target = "status", expression = "java(TransferredRecord.Status.valueOf(transferredRecordDTO.getStatus()))")
    TransferredRecord toEntity(TransferredRecordDTO transferredRecordDTO);
}