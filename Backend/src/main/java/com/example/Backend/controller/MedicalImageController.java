package com.example.Backend.controller;

import com.example.Backend.dto.MedicalImageDTO;
import com.example.Backend.service.MedicalImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medical-images")
@RequiredArgsConstructor
public class MedicalImageController {
    private final MedicalImageService medicalImageService;

    @GetMapping
    public ResponseEntity<List<MedicalImageDTO>> getAllMedicalImages() {
        return ResponseEntity.ok(medicalImageService.getAllMedicalImages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalImageDTO> getMedicalImageById(@PathVariable Integer id) {
        return ResponseEntity.ok(medicalImageService.getMedicalImageById(id));
    }

    @PostMapping
    public ResponseEntity<MedicalImageDTO> createMedicalImage(@RequestBody MedicalImageDTO medicalImageDTO) {
        return ResponseEntity.ok(medicalImageService.createMedicalImage(medicalImageDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalImageDTO> updateMedicalImage(@PathVariable Integer id, @RequestBody MedicalImageDTO medicalImageDTO) {
        return ResponseEntity.ok(medicalImageService.updateMedicalImage(id, medicalImageDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalImage(@PathVariable Integer id) {
        medicalImageService.deleteMedicalImage(id);
        return ResponseEntity.noContent().build();
    }
}