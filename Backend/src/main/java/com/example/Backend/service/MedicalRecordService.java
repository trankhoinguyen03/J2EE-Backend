package com.example.Backend.service;

import com.example.Backend.dto.MedicalRecordDTO;
import com.example.Backend.mapper.MedicalRecordMapper;
import com.example.Backend.model.MedicalRecord;
import com.example.Backend.repository.MedicalRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecordDTO> getAllMedicalRecords() {
        return medicalRecordRepository.findAll().stream()
                .map(MedicalRecordMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public MedicalRecordDTO getMedicalRecordById(Integer id) {
        return medicalRecordRepository.findById(id)
                .map(MedicalRecordMapper.INSTANCE::toDto)
                .orElseThrow(() -> new RuntimeException("MedicalRecord not found with id: " + id));
    }

    public MedicalRecordDTO createMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        MedicalRecord medicalRecord = MedicalRecordMapper.INSTANCE.toEntity(medicalRecordDTO);
        medicalRecord = medicalRecordRepository.save(medicalRecord);
        return MedicalRecordMapper.INSTANCE.toDto(medicalRecord);
    }

    public MedicalRecordDTO updateMedicalRecord(Integer id, MedicalRecordDTO medicalRecordDTO) {
        MedicalRecord existingMedicalRecord = medicalRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MedicalRecord not found with id: " + id));
        MedicalRecord updatedMedicalRecord = MedicalRecordMapper.INSTANCE.toEntity(medicalRecordDTO);
        updatedMedicalRecord.setId(existingMedicalRecord.getId());
        updatedMedicalRecord = medicalRecordRepository.save(updatedMedicalRecord);
        return MedicalRecordMapper.INSTANCE.toDto(updatedMedicalRecord);
    }

    public void deleteMedicalRecord(Integer id) {
        medicalRecordRepository.deleteById(id);
    }
}