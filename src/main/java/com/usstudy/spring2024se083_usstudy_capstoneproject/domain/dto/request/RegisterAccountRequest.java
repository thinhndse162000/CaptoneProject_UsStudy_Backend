package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegisterAccountRequest {
    private String fullName;
    private String email;
    private String password;
    private String address;
    private Date dateOfBirth;
    private String gender;
    private String phone;
}
