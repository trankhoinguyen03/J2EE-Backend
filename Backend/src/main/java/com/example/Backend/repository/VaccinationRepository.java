package com.example.Backend.repository;

import com.example.Backend.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<Vaccination, Integer> {
}