package com.example.Backend.dto;

import lombok.Data;

@Data
public class DoctorDTO {
    private Integer id;
    private Integer userId;
    private String specialty;
    private String hospital;
    private String phone;
}