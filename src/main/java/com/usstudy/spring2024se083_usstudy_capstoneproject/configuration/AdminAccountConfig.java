package com.usstudy.spring2024se083_usstudy_capstoneproject.configuration;

import lombok.Getter;
import org.springframework.context.annotation.Configuration;


@Getter
@Configuration
public class AdminAccountConfig {
    private final String ADMIN_EMAIL="admin@gmail.com";
    private final String ADMIN_PASSWORD="admin123";
}
