package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageSubmitRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageUpdateRequest;

public interface ApplyStageService {
    void submitApplyStage(ApplyStageSubmitRequest request);
    void updateApplyStage(Integer applyStageId,ApplyStageUpdateRequest request);


}
