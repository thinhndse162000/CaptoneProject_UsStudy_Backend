package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnglishScoreRequest {
    private float reading;
    private float listening;
    private float writing;
    private float speaking;
    private String file;
//    private Date createDate;
//    private Date updateDate;
    private Date dateOfExam;
    private Integer status;

    private Integer studentProfileId;
    private Integer certificateTypeId;
}
