package com.usstudy.spring2024se083_usstudy_capstoneproject.api;


import com.google.firebase.messaging.FirebaseMessagingException;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Notice;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation.NotificationServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v3/notification/")
@RestController
@Tag(name = "Notification-API")
public class NotificationApi {
    private final NotificationServiceImpl notificationService;

    @Autowired
    public NotificationApi(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("")
    public String sendNotification(@RequestBody Notice notice) throws FirebaseMessagingException {
        return notificationService.sendNotification(notice);
    }
}
