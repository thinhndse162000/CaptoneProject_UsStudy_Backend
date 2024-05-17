package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgramCertificateRequest {

    private Integer programCertificateId;
    private float minLevel;
    private float averageLevel;
    private Integer programId;
    private Integer certificateTypeId;
}
