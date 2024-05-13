package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileCreateRequest {

    @NotBlank(message = "Full Name Are not blank")
    private String fullName;
    @Email
    @NotBlank(message = "Email Are Not Blank")
    private String email;
    @NotBlank(message = "Date of birth Not Blank")
    private Date dateOfBirth;
    private String gender;
    @NotBlank(message = "Phone of birth Not Blank")
    private String phone;
    @NotBlank(message = "Address of birth Not Blank")
    private String address;
    @NotBlank(message = "Place of birth Not Blank")
    private String placeOfBirth;
    @NotBlank(message = "National Id Not Blank")
    private String nationalId;
    private String studyProcess;
    private List<String> fileString;
    private EnglishScoreRequest englishScoreRequest;
    private Integer customerId;
    private String img;
    private String englishLevel;
    private String grade;
}
