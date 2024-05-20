package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolProfileDto {
    private Integer schoolProfileId;
    private Integer studentProfileId;
    private String semester;
    private Integer schoolGrade;
    private String img;
    private Date createDate;
    private Date updateDate;
    private float gpa;
    private List<ProfileScoreDto> profileScoreDtos;
}
