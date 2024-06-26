package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RegistrationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_form_id")
    private int registrationFormId;
    private String area;
    @Column(name = "more_information")
    private String moreInformation;
    @Column(name = "study_abroad_reason")
    private String studyAbroadReason;
    @Column(name = "destination_reason")
    private String destinationReason;
    @Column(name = "program_choose")
    private String programChoose;
    @Column(name = "major_choose")
    private String majorChoose;
    @Column(name = "major_choose_reason")
    private String majorChooseReason;
    @Column(name = "university_choose_reason")
    private String universityChooseReason;
    @Column(name = "priority_of_study_abroad")
    private String priorityOfStudyAbroad;
    private String budget;
    private Integer status;
    @Column(name = "create_date")
    private Date createDate;
    //    @Column(name = "customer_id")
//    private Integer customerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonManagedReference
    private Customer customer;

    //    @Column(name = "consultant_id")
//    private Integer consultantId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultant_id")
    @JsonManagedReference
    private Consultant consultant;
}
