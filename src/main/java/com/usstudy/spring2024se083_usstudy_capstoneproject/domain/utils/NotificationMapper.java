package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.NotificationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotificationMapper {

    NotificationMapper INSTANT = Mappers.getMapper(NotificationMapper.class);

    NotificationDto toDto(Notification notification);
}
