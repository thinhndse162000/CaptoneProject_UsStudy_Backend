package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationCreateRequest {

    private Integer customerId;
    private Integer consultantId;
    private Integer registrationFormId;
    private Integer programId;
    private Integer applyStageId;
    private Integer programApplicationId;
}
