package com.example.Backend.service;

import com.example.Backend.dto.VaccinationDTO;
import com.example.Backend.mapper.VaccinationMapper;
import com.example.Backend.model.Vaccination;
import com.example.Backend.repository.VaccinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VaccinationService {
    private final VaccinationRepository vaccinationRepository;

    public List<VaccinationDTO> getAllVaccinations() {
        return vaccinationRepository.findAll().stream()
                .map(VaccinationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public VaccinationDTO getVaccinationById(Integer id) {
        return vaccinationRepository.findById(id)
                .map(VaccinationMapper.INSTANCE::toDto)
                .orElseThrow(() -> new RuntimeException("Vaccination not found with id: " + id));
    }

    public VaccinationDTO createVaccination(VaccinationDTO vaccinationDTO) {
        Vaccination vaccination = VaccinationMapper.INSTANCE.toEntity(vaccinationDTO);
        vaccination = vaccinationRepository.save(vaccination);
        return VaccinationMapper.INSTANCE.toDto(vaccination);
    }

    public VaccinationDTO updateVaccination(Integer id, VaccinationDTO vaccinationDTO) {
        Vaccination existingVaccination = vaccinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaccination not found with id: " + id));
        Vaccination updatedVaccination = VaccinationMapper.INSTANCE.toEntity(vaccinationDTO);
        updatedVaccination.setId(existingVaccination.getId());
        updatedVaccination = vaccinationRepository.save(updatedVaccination);
        return VaccinationMapper.INSTANCE.toDto(updatedVaccination);
    }

    public void deleteVaccination(Integer id) {
        vaccinationRepository.deleteById(id);
    }
}