package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.RegistrationForm;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.RegistrationFormMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationFormDto {
    private int registrationFormId;
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
    private Integer consultantId;

    public static RegistrationFormDto convert(RegistrationForm registrationForm) {
        return RegistrationFormMapper.INSTANCE.reigstrationFormToRegistrationFormDto(registrationForm);
    }
}
