package com.example.Backend.service;

import com.example.Backend.dto.FamilyDTO;
import com.example.Backend.mapper.FamilyMapper;
import com.example.Backend.model.Family;
import com.example.Backend.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FamilyService {
    private final FamilyRepository familyRepository;

    public List<FamilyDTO> getAllFamilies() {
        return familyRepository.findAll().stream()
                .map(FamilyMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public FamilyDTO getFamilyById(Integer id) {
        return familyRepository.findById(id)
                .map(FamilyMapper.INSTANCE::toDto)
                .orElseThrow(() -> new RuntimeException("Family not found with id: " + id));
    }

    public FamilyDTO createFamily(FamilyDTO familyDTO) {
        Family family = FamilyMapper.INSTANCE.toEntity(familyDTO);
        family = familyRepository.save(family);
        return FamilyMapper.INSTANCE.toDto(family);
    }

    public FamilyDTO updateFamily(Integer id, FamilyDTO familyDTO) {
        Family existingFamily = familyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Family not found with id: " + id));
        Family updatedFamily = FamilyMapper.INSTANCE.toEntity(familyDTO);
        updatedFamily.setId(existingFamily.getId());
        updatedFamily = familyRepository.save(updatedFamily);
        return FamilyMapper.INSTANCE.toDto(updatedFamily);
    }

    public void deleteFamily(Integer id) {
        familyRepository.deleteById(id);
    }
}