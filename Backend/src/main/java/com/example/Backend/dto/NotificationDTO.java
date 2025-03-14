package com.example.Backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class NotificationDTO {
    private Integer id;
    private Integer userId;
    private String message;
    private Boolean isRead;
    private LocalDateTime createdAt;
}