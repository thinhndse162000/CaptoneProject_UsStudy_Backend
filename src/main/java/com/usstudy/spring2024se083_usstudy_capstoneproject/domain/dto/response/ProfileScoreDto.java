package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileScoreDto {
    private Integer profileScoreId;
    private SubjectDto subjectDto;
    private float score;
    private Integer schoolProfileId;
}
