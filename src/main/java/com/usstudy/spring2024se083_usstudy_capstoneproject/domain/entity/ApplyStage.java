package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer applyStageId;
    private Integer studentProfileId;
    private Integer programStageId;
    private Date updateDate;
    private String status;
}
