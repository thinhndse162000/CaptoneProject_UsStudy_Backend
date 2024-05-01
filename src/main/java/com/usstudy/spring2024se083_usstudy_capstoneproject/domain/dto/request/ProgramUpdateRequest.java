package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramUpdateRequest {
    
    private String nameProgram;
    private String status;
    private Date createDate;
    private Date modifiedDate;
    private Integer modifier;
    private String duration;
    private String description;
    private String tuition;
    private String level;
    private String img;
    private String responsibilities;
    private String requirement;
    private Integer universityId;
    private String fileDownload;

    private Integer majorId;

    private Integer semesterId;

    private Integer programTypeId;
}
