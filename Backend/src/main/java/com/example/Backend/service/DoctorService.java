package com.example.Backend.service;

import com.example.Backend.dto.DoctorDTO;
import com.example.Backend.mapper.DoctorMapper;
import com.example.Backend.model.Doctor;
import com.example.Backend.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(DoctorMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public DoctorDTO getDoctorById(Integer id) {
        return doctorRepository.findById(id)
                .map(DoctorMapper.INSTANCE::toDto)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = DoctorMapper.INSTANCE.toEntity(doctorDTO);
        doctor = doctorRepository.save(doctor);
        return DoctorMapper.INSTANCE.toDto(doctor);
    }

    public DoctorDTO updateDoctor(Integer id, DoctorDTO doctorDTO) {
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
        Doctor updatedDoctor = DoctorMapper.INSTANCE.toEntity(doctorDTO);
        updatedDoctor.setId(existingDoctor.getId());
        updatedDoctor = doctorRepository.save(updatedDoctor);
        return DoctorMapper.INSTANCE.toDto(updatedDoctor);
    }

    public void deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);
    }
}