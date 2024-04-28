package com.usstudy.spring2024se083_usstudy_capstoneproject.service;


import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.NotificationCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.NotificationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Notification;

import java.util.List;

public interface NotificationService {

    Notification createNotification(NotificationCreateRequest request);

    List<NotificationDto> getNotificationByCustomerId(Integer id);
}
