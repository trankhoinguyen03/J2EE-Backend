package com.example.Backend.dto;

import lombok.Data;

@Data
public class MedicalImageDTO {
    private Integer id;
    private Integer recordId;
    private String imageUrl;
    private String description;
}