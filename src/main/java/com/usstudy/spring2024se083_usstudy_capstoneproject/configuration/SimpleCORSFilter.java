package com.usstudy.spring2024se083_usstudy_capstoneproject.configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class SimpleCORSFilter {
    //    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://usstudy-be:8080"
                                , "https://usstudy.monoinfinity.net/swagger-ui/index.html"
                                , "http://localhost:3000"
                                , "http://localhost:8080"
                                , "https://usstudy.monoinfinity.net"
                                , "103.118.28.112:443"
                        )

                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowedOrigins("*")
                        .maxAge(-1);
            }
        };
    }

}
