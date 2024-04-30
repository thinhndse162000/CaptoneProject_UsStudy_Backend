package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramStage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplyStageDto {
    private Integer applyStageId;
    private Date updateDate;
    private Integer programStageId;
    private Integer programApplicationId;
    private Integer status;
    private ProgramStageDto programStage;
}
