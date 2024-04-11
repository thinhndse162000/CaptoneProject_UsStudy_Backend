package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageSubmitRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplyStateDto;


import java.util.List;
import java.util.Optional;

public interface ApplyStageService {
    void submitApplyStage(ApplyStageSubmitRequest request);

    void updateApplyStage(Integer applyStageId, ApplyStageUpdateRequest request);

    List<ApplyStateDto> getAllApplyStage();

    Optional<ApplyStateDto> getById(Integer id);
}
