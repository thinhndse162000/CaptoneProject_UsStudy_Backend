package com.usstudy.spring2024se083_usstudy_capstoneproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
}
