package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.CertificateType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProgramCertificateDto {

    private Integer programCertificateId;
    private float minLevel;
    private float averageLevel;
    private Integer programId;
    private Integer certificateTypeId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Program program;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CertificateType certificateType;
}
