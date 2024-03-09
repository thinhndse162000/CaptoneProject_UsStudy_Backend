package com.usstudy.spring2024se083_usstudy_capstoneproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Spring2024Se083UsStudyCapstoneProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring2024Se083UsStudyCapstoneProjectApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("v3/**").allowedOrigins("http://usstudy-be:8080", "192.168.1.13");
            }
        };
    }
}
