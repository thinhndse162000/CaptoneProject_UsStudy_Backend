package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UploadFile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfileUpdateRequest {
    @NotBlank(message = "Full name number must not be blank")
    private String fullName;
    @NotBlank(message = "Email number must not be blank")
    @Email
    private String email;
    @NotBlank(message = "Date Of Birth number must not be blank")
    private Date dateOfBirth;
    @NotBlank(message = "Gender number must not be blank")
    private String gender;
    @NotBlank(message = "Phone number must not be blank")
    private String phone;
    @NotBlank(message = "Address number must not be blank")
    private String address;
    @NotBlank(message = "Place Of Birth number must not be blank")
    private String placeOfBirth;
    @NotBlank(message = "National number must not be blank")
    private String national;
    @NotBlank(message = "National Id number must not be blank")
    private String nationalId;
    @NotBlank(message = "Study Proccess number must not be blank")
    private String studyProcess;
    private String englishLevel;
    private String grade;
    private String img;
    ArrayList<UploadFile> fileUploads;
}
