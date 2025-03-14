package com.example.Backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransferredRecordDTO {
    private Integer id;
    private Integer recordId;
    private Integer doctorId;
    private String status;
    private LocalDateTime transferredAt;
}