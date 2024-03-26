package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_stage_id")
    private Integer programStageId;
    @Column(name = "stage_name")
    private String StageName;
//    @Column(name = "program_id")
//    private Integer programId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id",nullable = false)
    @JsonManagedReference
    private Program program;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "programStage")
    @JsonBackReference
    private List<ApplyStage> applyStages;
}
