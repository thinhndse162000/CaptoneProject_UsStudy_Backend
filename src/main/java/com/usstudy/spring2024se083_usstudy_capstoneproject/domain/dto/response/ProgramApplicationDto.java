package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramApplication;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramApplicationMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramApplicationDto {
    private Integer programApplicationId;
    private Date updateDate;
    private Integer studentProfileId;
    private Integer programId;
    private Integer applyStageId;

    public static ProgramApplicationDto convert(ProgramApplication programApplication) {
        return ProgramApplicationMapper.INSTANCE.toDto(programApplication);
    }
}
