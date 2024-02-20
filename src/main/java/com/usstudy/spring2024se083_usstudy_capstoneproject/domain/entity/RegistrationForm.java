package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RegistrationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int registrationFormId;
    private String area;
    private String moreInformation;
    private String studyAbroadReason;
    private String destinationReason;
    private String programChoose;
    private String majorChoose;
    private String majorChooseReason;
    private String universityChooseReason;
    private String priorityOfStudyProgram;
    private String budget;
    private Integer customerId;
    private Integer consultantId;
}
