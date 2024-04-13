package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistrationFormCreateRequest {
    private String area;
    private String moreInformation;
    private String studyAbroadReason;
    private String destinationReason;
    private String programChoose;
    private String majorChoose;
    private String majorChooseReason;
    private String universityChooseReason;
    private String priorityOfStudyAbroad;
    private String budget;
    private Integer customerId;
    private Integer status;
}
