package com.example.Backend.service;

import com.example.Backend.dto.NotificationDTO;
import com.example.Backend.mapper.NotificationMapper;
import com.example.Backend.model.Notification;
import com.example.Backend.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(NotificationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    public NotificationDTO getNotificationById(Integer id) {
        return notificationRepository.findById(id)
                .map(NotificationMapper.INSTANCE::toDto)
                .orElseThrow(() -> new RuntimeException("Notification not found with id: " + id));
    }

    public NotificationDTO createNotification(NotificationDTO notificationDTO) {
        Notification notification = NotificationMapper.INSTANCE.toEntity(notificationDTO);
        notification = notificationRepository.save(notification);
        return NotificationMapper.INSTANCE.toDto(notification);
    }

    public NotificationDTO updateNotification(Integer id, NotificationDTO notificationDTO) {
        Notification existingNotification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found with id: " + id));
        Notification updatedNotification = NotificationMapper.INSTANCE.toEntity(notificationDTO);
        updatedNotification.setId(existingNotification.getId());
        updatedNotification = notificationRepository.save(updatedNotification);
        return NotificationMapper.INSTANCE.toDto(updatedNotification);
    }

    public void deleteNotification(Integer id) {
        notificationRepository.deleteById(id);
    }
}