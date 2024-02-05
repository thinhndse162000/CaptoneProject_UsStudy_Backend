package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "student_profile_id")
    private Integer studentProfileId;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    private String gender;
    private String phone;
    private String address;
    @Column(name= "create_date")
    private Date createDate;
    @Column(name = "place_of_birth")
    private String placeOfBirth;
    @Column(name = "national_id")
    private String nationalId;
    @Column(name = "study_process")
    private String studyProcess;
    @Column(name = "customer_id")
    private Integer customerId;
}
