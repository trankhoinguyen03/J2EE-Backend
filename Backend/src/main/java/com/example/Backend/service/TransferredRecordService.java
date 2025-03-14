package com.example.Backend.service;

import com.example.Backend.dto.TransferredRecordDTO;
import com.example.Backend.mapper.TransferredRecordMapper;
import com.example.Backend.model.TransferredRecord;
import com.example.Backend.repository.TransferredRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransferredRecordService {
    private final TransferredRecordRepository transferredRecordRepository;

    public List<TransferredRecordDTO> getAllTransferredRecords() {
        return transferredRecordRepository.findAll().stream()
                .map(TransferredRecordMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public TransferredRecordDTO getTransferredRecordById(Integer id) {
        return transferredRecordRepository.findById(id)
                .map(TransferredRecordMapper.INSTANCE::toDto)
                .orElseThrow(() -> new RuntimeException("TransferredRecord not found with id: " + id));
    }

    public TransferredRecordDTO createTransferredRecord(TransferredRecordDTO transferredRecordDTO) {
        TransferredRecord transferredRecord = TransferredRecordMapper.INSTANCE.toEntity(transferredRecordDTO);
        transferredRecord = transferredRecordRepository.save(transferredRecord);
        return TransferredRecordMapper.INSTANCE.toDto(transferredRecord);
    }

    public TransferredRecordDTO updateTransferredRecord(Integer id, TransferredRecordDTO transferredRecordDTO) {
        TransferredRecord existingTransferredRecord = transferredRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TransferredRecord not found with id: " + id));
        TransferredRecord updatedTransferredRecord = TransferredRecordMapper.INSTANCE.toEntity(transferredRecordDTO);
        updatedTransferredRecord.setId(existingTransferredRecord.getId());
        updatedTransferredRecord = transferredRecordRepository.save(updatedTransferredRecord);
        return TransferredRecordMapper.INSTANCE.toDto(updatedTransferredRecord);
    }

    public void deleteTransferredRecord(Integer id) {
        transferredRecordRepository.deleteById(id);
    }
}