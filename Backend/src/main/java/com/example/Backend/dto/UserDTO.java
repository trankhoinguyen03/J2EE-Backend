package com.example.Backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Integer id;
    private String fullName;
    private String email;
    private String role;
    private LocalDateTime createdAt;
}