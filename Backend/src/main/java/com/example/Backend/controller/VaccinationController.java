package com.example.Backend.controller;

import com.example.Backend.dto.VaccinationDTO;
import com.example.Backend.service.VaccinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vaccinations")
@RequiredArgsConstructor
public class VaccinationController {
    private final VaccinationService vaccinationService;

    @GetMapping
    public ResponseEntity<List<VaccinationDTO>> getAllVaccinations() {
        return ResponseEntity.ok(vaccinationService.getAllVaccinations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaccinationDTO> getVaccinationById(@PathVariable Integer id) {
        return ResponseEntity.ok(vaccinationService.getVaccinationById(id));
    }

    @PostMapping
    public ResponseEntity<VaccinationDTO> createVaccination(@RequestBody VaccinationDTO vaccinationDTO) {
        return ResponseEntity.ok(vaccinationService.createVaccination(vaccinationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VaccinationDTO> updateVaccination(@PathVariable Integer id, @RequestBody VaccinationDTO vaccinationDTO) {
        return ResponseEntity.ok(vaccinationService.updateVaccination(id, vaccinationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVaccination(@PathVariable Integer id) {
        vaccinationService.deleteVaccination(id);
        return ResponseEntity.noContent().build();
    }
}