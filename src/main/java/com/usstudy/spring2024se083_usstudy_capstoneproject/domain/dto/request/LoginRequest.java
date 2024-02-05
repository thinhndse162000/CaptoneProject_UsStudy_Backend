package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    @Email
    private String email;
    private String password;
}
