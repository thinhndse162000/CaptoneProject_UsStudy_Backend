package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageSubmitRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;

import java.util.Optional;

public interface ApplyStageService {
    void submitApplyStage(ApplyStageSubmitRequest request);

    void updateApplyStage(Integer applyStageId, ApplyStageUpdateRequest request);

    Iterable<ApplyStage> getAllApplyStage();

    Optional<ApplyStage> getById(Integer id);
}
