package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SubjectDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileScoreRequest {
    private Integer subjectId;
    private float score;
    private Integer schoolProfileId;
}
