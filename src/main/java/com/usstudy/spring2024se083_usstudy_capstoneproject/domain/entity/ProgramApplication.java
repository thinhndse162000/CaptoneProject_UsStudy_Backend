package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

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
    @Column(name = "student_profile_id")
    private Integer studentProfileId;
    @Column(name = "program_id")
    private Integer programId;
    @Column(name = "apply_stage_id")
    private Integer applyStageId;
    @Column(name = "update_date")
    private Date updateDate;
}
