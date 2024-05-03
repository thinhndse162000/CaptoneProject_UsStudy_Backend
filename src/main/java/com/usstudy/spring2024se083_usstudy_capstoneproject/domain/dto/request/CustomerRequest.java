package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private Integer customerId;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    private String password;
    private String address;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    private String gender;
    private String phone;
    private String img;
}
