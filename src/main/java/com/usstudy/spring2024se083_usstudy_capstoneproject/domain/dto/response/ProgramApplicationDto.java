package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramApplication;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramApplicationMapper;
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
public class ProgramApplicationDto {
    private Integer programApplicationId;
    private Date updateDate;
    private Integer studentProfileId;
    private Integer programId;
    //private Integer applyStageId;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<ApplyStageDto> applyStage;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private StudentProfileDto studentProfile;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Program program;
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    private List<ApplicationFee> applicationFees;

    public static ProgramApplicationDto convert(ProgramApplication programApplication) {
        return ProgramApplicationMapper.INSTANCE.toDto(programApplication);
    }
}
