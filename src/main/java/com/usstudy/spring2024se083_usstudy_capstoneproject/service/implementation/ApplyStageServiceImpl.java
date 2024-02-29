package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageSubmitRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ApplyStageRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ApplyStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class ApplyStageServiceImpl implements ApplyStageService {
    private final ApplyStageRepository applyStageRepository;

    @Autowired
    public ApplyStageServiceImpl(ApplyStageRepository applyStageRepository) {
        this.applyStageRepository = applyStageRepository;
    }

    @Override
    public void submitApplyStage(ApplyStageSubmitRequest request) {
        ApplyStage applyStage = new ApplyStage();

        applyStage.setApplyStageId(0);
        applyStage.setStudentProfileId(request.getStudentProfileId());
        applyStage.setProgramStageId(request.getProgramStageId());
        applyStage.setUpdateDate(new Date(System.currentTimeMillis()));
        applyStage.setStatus(request.getStatus());

        applyStageRepository.save(applyStage);
    }

    @Override
    public void updateApplyStage(Integer applyStageId, ApplyStageUpdateRequest request) {
        ApplyStage applyStage = applyStageRepository.findById(applyStageId)
                .orElseThrow(() -> new NullPointerException("Student Profile not found - " + applyStageId));

        applyStage.setUpdateDate(new Date(System.currentTimeMillis()));
        applyStage.setStatus(request.getStatus());
        applyStage.setProgramStageId(request.getProgramStageId());

        applyStageRepository.save(applyStage);
    }

    @Override
    public Iterable<ApplyStage> getAllApplyStage() {
        return applyStageRepository.findAll();
    }

    @Override
    public Optional<ApplyStage> getById(Integer id) {
        return applyStageRepository.findById(id);
    }


}
