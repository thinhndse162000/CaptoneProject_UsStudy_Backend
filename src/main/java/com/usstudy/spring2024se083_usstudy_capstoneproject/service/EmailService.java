package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
