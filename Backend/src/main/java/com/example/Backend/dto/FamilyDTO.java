package com.example.Backend.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FamilyDTO {
    private Integer id;
    private Integer userId;
    private String memberName;
    private LocalDate birthDate;
    private String gender;
    private String relationship;
}