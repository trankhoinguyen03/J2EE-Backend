package com.example.Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseCheckService implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        try {
            int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM information_schema.tables", Integer.class);
            System.out.println("Kết nối MySQL thành công! Tổng số bảng: " + count);
        } catch (Exception e) {
            System.err.println("Lỗi kết nối MySQL: " + e.getMessage());
        }
    }
}

