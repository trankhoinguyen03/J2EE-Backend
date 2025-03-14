package com.example.Backend.mapper;

import com.example.Backend.dto.NotificationDTO;
import com.example.Backend.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotificationMapper {
    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", expression = "java(notification.getUser() != null ? notification.getUser().getId() : null)")
    @Mapping(target = "message", source = "message")
    @Mapping(target = "isRead", source = "isRead")
    @Mapping(target = "createdAt", source = "createdAt")
    NotificationDTO toDto(Notification notification);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "user.id", expression = "java(notificationDTO.getUserId() != null ? notificationDTO.getUserId() : null)")
    @Mapping(target = "message", source = "message")
    @Mapping(target = "isRead", source = "isRead")
    @Mapping(target = "createdAt", source = "createdAt")
    Notification toEntity(NotificationDTO notificationDTO);
}