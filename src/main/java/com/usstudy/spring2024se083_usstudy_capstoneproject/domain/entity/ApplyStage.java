package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ApplyStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apply_stage_id")
    private Integer applyStageId;
    @Column(name = "student_profile_id")
    private Integer studentProfileId;
    @Column(name = "program_stage_id")
    private Integer programStageId;
    @Column(name = "update_date")
    private Date updateDate;
    private String status;
}
