package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_application_id")
    private Integer programApplicationId;
//    @Column(name = "student_profile_id")
//    private Integer studentProfileId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_profile_id",nullable = false)
    @JsonManagedReference
    private StudentProfile studentProfile;
//    @Column(name = "program_id")
//    private Integer programId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id",nullable = false)
    @JsonManagedReference
    private Program program;

//    @Column(name = "apply_stage_id")
//    private Integer applyStageId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apply_stage_id",nullable = false)
    @JsonManagedReference
    private ApplyStage applyStage;

    @Column(name = "update_date")
    private Date updateDate;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "programApplication")
    @JsonBackReference
    private List<Payment> payments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "programApplication")
    @JsonBackReference
    private List<ApplicationFee> applicationFees;
}
