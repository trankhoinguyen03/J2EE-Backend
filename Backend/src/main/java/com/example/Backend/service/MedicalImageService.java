package com.example.Backend.service;

import com.example.Backend.dto.MedicalImageDTO;
import com.example.Backend.mapper.MedicalImageMapper;
import com.example.Backend.model.MedicalImage;
import com.example.Backend.repository.MedicalImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalImageService {
    private final MedicalImageRepository medicalImageRepository;

    public List<MedicalImageDTO> getAllMedicalImages() {
        return medicalImageRepository.findAll().stream()
                .map(MedicalImageMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public MedicalImageDTO getMedicalImageById(Integer id) {
        return medicalImageRepository.findById(id)
                .map(MedicalImageMapper.INSTANCE::toDto)
                .orElseThrow(() -> new RuntimeException("MedicalImage not found with id: " + id));
    }

    public MedicalImageDTO createMedicalImage(MedicalImageDTO medicalImageDTO) {
        MedicalImage medicalImage = MedicalImageMapper.INSTANCE.toEntity(medicalImageDTO);
        medicalImage = medicalImageRepository.save(medicalImage);
        return MedicalImageMapper.INSTANCE.toDto(medicalImage);
    }

    public MedicalImageDTO updateMedicalImage(Integer id, MedicalImageDTO medicalImageDTO) {
        MedicalImage existingMedicalImage = medicalImageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MedicalImage not found with id: " + id));
        MedicalImage updatedMedicalImage = MedicalImageMapper.INSTANCE.toEntity(medicalImageDTO);
        updatedMedicalImage.setId(existingMedicalImage.getId());
        updatedMedicalImage = medicalImageRepository.save(updatedMedicalImage);
        return MedicalImageMapper.INSTANCE.toDto(updatedMedicalImage);
    }

    public void deleteMedicalImage(Integer id) {
        medicalImageRepository.deleteById(id);
    }
}