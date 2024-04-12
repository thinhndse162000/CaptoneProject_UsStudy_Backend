package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notice implements Serializable {
    /**
     * Subject notification on firebase
     */
    private String subject;
    /**
     * Content notification on firebase
     */
    private String content;
    /**
     * url ảnh đại diện đơn hàng
     */
    private String image;
    /**
     * Map các data
     */
    private Map<String, String> data;
    /**
     * FCM registration token
     */
    private String registrationTokens;
}
