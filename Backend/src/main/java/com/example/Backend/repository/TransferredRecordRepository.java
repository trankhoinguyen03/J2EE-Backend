package com.example.Backend.repository;

import com.example.Backend.model.TransferredRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferredRecordRepository extends JpaRepository<TransferredRecord, Integer> {
}