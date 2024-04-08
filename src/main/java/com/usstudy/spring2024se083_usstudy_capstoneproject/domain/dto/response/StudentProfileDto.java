package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileDto {
    private Integer studentProfileId;
    private String fullName;
    private String email;
    private Date dateOfBirth;
    private String gender;
    private String phone;
    private String address;
    private Date createDate;
    private String placeOfBirth;
    private String nationalId;
    private String studyProcess;
    private Integer customerId;
}
