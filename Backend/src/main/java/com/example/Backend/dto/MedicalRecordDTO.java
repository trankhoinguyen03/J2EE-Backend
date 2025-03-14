package com.example.Backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MedicalRecordDTO {
    private Integer id;
    private Integer familyId;
    private Integer doctorId;
    private String diagnosis;
    private String treatment;
    private LocalDate visitDate;
}