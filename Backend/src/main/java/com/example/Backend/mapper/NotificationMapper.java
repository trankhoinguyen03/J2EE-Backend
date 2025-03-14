package com.example.Backend.mapper;

import com.example.Backend.dto.NotificationDTO;
import com.example.Backend.model.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotificationMapper {
    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    @Mapping(target = "userId", source = "user.id")
    NotificationDTO toDto(Notification notification);

    @Mapping(target = "user.id", source = "userId")
    Notification toEntity(NotificationDTO notificationDTO);
}