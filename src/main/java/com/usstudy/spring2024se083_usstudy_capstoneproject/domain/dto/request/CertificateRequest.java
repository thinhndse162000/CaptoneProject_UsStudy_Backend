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
public class CertificateRequest {
    private Integer certificateId;
    private float certificateValue;
    private String file;
    private Date issueDate;

    private Integer studentProfileId;
    private Integer certificateTypeId;
}
