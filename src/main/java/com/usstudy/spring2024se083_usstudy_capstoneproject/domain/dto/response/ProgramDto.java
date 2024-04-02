package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramDto {
    private Integer programId;
    private String nameProgram;
    private String status;
    private Date createDate;
    private Date modifiedDate;
    private Integer modifier;
    private String duration;
    private String description;
    private float tuition;
    private String level;
    private String img;
    private Integer universityId;

    private Integer majorId;

    private Integer semesterId;

    private Integer programTypeId;
}
