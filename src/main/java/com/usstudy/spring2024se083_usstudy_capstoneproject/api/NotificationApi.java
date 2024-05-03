package com.usstudy.spring2024se083_usstudy_capstoneproject.api;


import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.NotificationCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.NotificationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Notification;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.NotificationService;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation.NotificationServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v3/notification/")
@RestController
@Tag(name = "Notification-API")
public class NotificationApi {
    private final NotificationService notificationService;

    @Autowired
    public NotificationApi(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

//    @PostMapping("")
//    public String sendNotification(@RequestBody Notice notice) throws FirebaseMessagingException {
//        return notificationService.sendNotification(notice);
//    }

    @PostMapping("")
    public ResponseEntity<Notification> createNotification(@RequestBody NotificationCreateRequest request) {
        return ResponseEntity.ok(notificationService.createNotification(request));
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<List<NotificationDto>> getNotification(@PathVariable Integer id) {
        return ResponseEntity.ok(notificationService.getNotificationByCustomerId(id));
    }
}
