package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Notification;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.NotificationMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {

    private Integer notificationId;
    private String content;
    private Date date;
    private String title;
    @JsonIgnore
    private Customer customer;

    public static NotificationDto convert(Notification notification) {
        return NotificationMapper.INSTANT.toDto(notification);
    }
}
