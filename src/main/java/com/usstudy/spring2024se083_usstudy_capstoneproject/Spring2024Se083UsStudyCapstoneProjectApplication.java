package com.usstudy.spring2024se083_usstudy_capstoneproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@OpenAPIDefinition(
        servers = {
                @Server(url = "https://usstudy.monoinfinity.net", description = "Default Server URL")
        }
)
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
