package com.example.Backend.controller;

import com.example.Backend.dto.TransferredRecordDTO;
import com.example.Backend.service.TransferredRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transferred-records")
@RequiredArgsConstructor
public class TransferredRecordController {
    private final TransferredRecordService transferredRecordService;

    @GetMapping
    public ResponseEntity<List<TransferredRecordDTO>> getAllTransferredRecords() {
        return ResponseEntity.ok(transferredRecordService.getAllTransferredRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferredRecordDTO> getTransferredRecordById(@PathVariable Integer id) {
        return ResponseEntity.ok(transferredRecordService.getTransferredRecordById(id));
    }

    @PostMapping
    public ResponseEntity<TransferredRecordDTO> createTransferredRecord(@RequestBody TransferredRecordDTO transferredRecordDTO) {
        return ResponseEntity.ok(transferredRecordService.createTransferredRecord(transferredRecordDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransferredRecordDTO> updateTransferredRecord(@PathVariable Integer id, @RequestBody TransferredRecordDTO transferredRecordDTO) {
        return ResponseEntity.ok(transferredRecordService.updateTransferredRecord(id, transferredRecordDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransferredRecord(@PathVariable Integer id) {
        transferredRecordService.deleteTransferredRecord(id);
        return ResponseEntity.noContent().build();
    }
}