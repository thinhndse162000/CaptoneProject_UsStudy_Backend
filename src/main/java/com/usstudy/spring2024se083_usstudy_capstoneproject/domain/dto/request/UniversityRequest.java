package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniversityRequest {
    private Integer universityId;
    private String universityName;
    private Float tuition;
    private String description;

    private Integer staffId;
    private Integer universityTypeId;

    private Integer stateId;
    private String img;
    private String slogan;
    private String website;
    private String email;
}
