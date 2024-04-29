package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramApplicationRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplyStateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramApplicationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramStageDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramApplication;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ApplyStageMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramApplicationMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramStageMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ApplyStageRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramApplicationRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramStageRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramApplicationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramApplicationServiceImpl implements ProgramApplicationService {
    private final ProgramApplicationRepository programApplicationRepository;
    private final ApplyStageRepository applyStageRepository;
    private final ProgramStageRepository programStageRepository;

    @Override
    public Optional getById(Integer id) {
        return programApplicationRepository.findById(id).map(ProgramApplicationMapper.INSTANCE::toDto);
    }

    @Override
    public List<ProgramApplicationDto> getAllFilter() {
        return programApplicationRepository.findAll()
                .stream().map(ProgramApplicationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgramApplicationDto> getByStudentProfileId(Integer id) {
        return programApplicationRepository.findByStudentProfileStudentProfileId(id)
                .stream().map(ProgramApplicationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProgramApplicationDto saveProgramApplication(ProgramApplicationRequest programApplicationRequest,Integer programApplicationId, Integer stageNo) {

        List<ProgramStage> programStageList =
                programStageRepository.getProgramStageByProgramIdOrderByProgramStageIdAcs(programApplicationRequest.getProgramId());
        if (programStageList.isEmpty())
            return null;
        ProgramStage programStage;

        try {
            if (stageNo != null) {
                programStage = programStageList.get(stageNo);
            } else {
                programStage = programStageList.get(0);
            }
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
        if (programApplicationId!=null){
            ProgramApplication programApplication=programApplicationRepository.findById(programApplicationId)
                    .orElseThrow(() -> new NullPointerException("No Program Application -"+programApplicationId));
            MergeRequest.mergeIgnoreNullValue(programApplicationRequest,programApplication);
            return ProgramApplicationMapper.INSTANCE.toDto(
                    programApplicationRepository.save(programApplication)
            );
        }
        ProgramApplication resultProgramApplication=programApplicationRepository.save(ProgramApplicationMapper.INSTANCE.toEntity(programApplicationRequest));
        ApplyStateDto saveApplyStage = new ApplyStateDto();
        saveApplyStage.setProgramStageId(programStage.getProgramStageId());
        saveApplyStage.setProgramApplicationId(programApplicationRequest.getProgramApplicationId());
        saveApplyStage.setUpdateDate(new Date(System.currentTimeMillis()));

        applyStageRepository.save(ApplyStageMapper.INSTANCE.toEntity(saveApplyStage));
        return ProgramApplicationMapper.INSTANCE.toDto(
                resultProgramApplication
        );
    }

    @Override
    public List<ProgramApplicationDto> getByCustomerId(Integer id) {
        List<ProgramApplication> programApplications = programApplicationRepository.getProgramApplicationByCustomerId(id);
        return programApplications.stream()
                .map(ProgramApplicationDto::convert)
                .collect(Collectors.toList());
    }
}
