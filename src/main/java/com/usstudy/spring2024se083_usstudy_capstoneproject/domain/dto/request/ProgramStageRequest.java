package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramStageRequest {
    private Integer programStageId;
    private String StageName;
    private Integer programId;
    private Boolean isPayment;
    private Integer programFeeId;
}
