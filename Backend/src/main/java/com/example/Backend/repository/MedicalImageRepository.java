package com.example.Backend.repository;

import com.example.Backend.model.MedicalImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalImageRepository extends JpaRepository<MedicalImage, Integer> {
}