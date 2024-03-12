package com.usstudy.spring2024se083_usstudy_capstoneproject.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/swagger-ui/**"
                                , "v3/api-docs/**"
                                , "v3/api-docs"
                                , "v3/account/**"
                                , "/v3/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "v3/account/login").permitAll()
                        .anyRequest().authenticated()
                ).formLogin(form -> form.disable())
        ;
        return http.build();
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://usstudy-be:8080"
//                        , "https://usstudy.monoinfinity.net/swagger-ui/index.html"
//                        , "http://localhost:3000"
//                        , "http://localhost:8080"
//                        , "https://usstudy.monoinfinity.net"
//                )
//
//                .allowedMethods("*")
//                .allowedHeaders("*")
//                .allowedOrigins("*")
//                .maxAge(-1);
//    }

}
