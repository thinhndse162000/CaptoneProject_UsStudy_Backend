package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageSubmitRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ApplyStageRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramStageRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ApplyStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class ApplyStageServiceImpl implements ApplyStageService {
    private final ApplyStageRepository applyStageRepository;

    private final ProgramStageRepository programStageRepository;


    @Autowired
    public ApplyStageServiceImpl(ApplyStageRepository applyStageRepository, ProgramStageRepository programStageRepository) {
        this.applyStageRepository = applyStageRepository;
        this.programStageRepository = programStageRepository;
    }

    @Override
    public void submitApplyStage(ApplyStageSubmitRequest request) {
        ApplyStage applyStage = new ApplyStage();
        ProgramStage programStage = programStageRepository.findById(request.getProgramStageId())
                .orElseThrow(() -> new NullPointerException("Program not found - " + request.getProgramStageId()));
        applyStage.setApplyStageId(0);
        applyStage.setProgramStage(programStage);
        applyStage.setUpdateDate(new Date(System.currentTimeMillis()));
        applyStage.setPaymentStatus(request.getStatus());

        applyStageRepository.save(applyStage);
    }

    @Override
    public void updateApplyStage(Integer applyStageId, ApplyStageUpdateRequest request) {
        ApplyStage applyStage = applyStageRepository.findById(applyStageId)
                .orElseThrow(() -> new NullPointerException("Student Profile not found - " + applyStageId));
        ProgramStage programStage = programStageRepository.findById(request.getProgramStageId())
                .orElseThrow(() -> new NullPointerException("Program not found - " + request.getProgramStageId()));
        applyStage.setUpdateDate(new Date(System.currentTimeMillis()));
        applyStage.setPaymentStatus(request.getStatus());
        applyStage.setProgramStage(programStage);

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
