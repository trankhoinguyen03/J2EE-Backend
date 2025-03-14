package com.example.Backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class VaccinationDTO {
    private Integer id;
    private Integer familyId;
    private String vaccineName;
    private LocalDate vaccinationDate;
    private String status;
}