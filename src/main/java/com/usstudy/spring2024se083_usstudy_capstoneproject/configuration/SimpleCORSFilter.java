package com.usstudy.spring2024se083_usstudy_capstoneproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class SimpleCORSFilter {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://usstudy-be:8080", "https://usstudy.monoinfinity.net/swagger-ui/index.html", "http://localhost:3000")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowedOrigins("*")
                        .maxAge(-1);
            }
        };
    }

}
