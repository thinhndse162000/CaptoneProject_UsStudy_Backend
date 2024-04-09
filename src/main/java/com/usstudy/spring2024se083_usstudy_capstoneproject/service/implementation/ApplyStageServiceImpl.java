package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageSubmitRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplyStateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ApplyStageMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ApplyStageRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramStageRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ApplyStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        applyStageRepository.save(applyStage);
    }

    @Override
    public void updateApplyStage(Integer applyStageId, ApplyStageUpdateRequest request) {
        ApplyStage applyStage = applyStageRepository.findById(applyStageId)
                .orElseThrow(() -> new NullPointerException("Student Profile not found - " + applyStageId));
        ProgramStage programStage = programStageRepository.findById(request.getProgramStageId())
                .orElseThrow(() -> new NullPointerException("Program not found - " + request.getProgramStageId()));
        applyStage.setUpdateDate(new Date(System.currentTimeMillis()));
        applyStage.setProgramStage(programStage);

        applyStageRepository.save(applyStage);
    }

    @Override
    public List<ApplyStateDto> getAllApplyStage() {
        return applyStageRepository.findAll()
                .stream().map(ApplyStageMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ApplyStateDto> getById(Integer id) {
        return applyStageRepository.findById(id)
                .map(ApplyStageMapper.INSTANCE::toDto);
    }


}
