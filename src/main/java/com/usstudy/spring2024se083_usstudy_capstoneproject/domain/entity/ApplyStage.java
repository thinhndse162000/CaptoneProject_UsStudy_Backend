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
//    @Column(name = "program_stage_id")
//    private Integer programStageId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_stage_id",nullable = false)
    @JsonManagedReference
    private ProgramStage programStage;

    @Column(name = "update_date")
    private Date updateDate;
    @Column(name = "payment_status")
    private int paymentStatus;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "applyStage")
    @JsonBackReference
    private List<ProgramApplication> programApplications;
}
