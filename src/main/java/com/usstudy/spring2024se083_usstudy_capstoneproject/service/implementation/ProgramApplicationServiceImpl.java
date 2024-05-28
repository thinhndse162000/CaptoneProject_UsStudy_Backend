package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.MergeRequest.MergeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramApplicationRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramApplicationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramApplication;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramApplicationMapper;
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
    public ProgramApplicationDto saveProgramApplication(ProgramApplicationRequest programApplicationRequest,Integer programApplicationId) {

        List<ProgramStage> programStageList =
                programStageRepository.getProgramStageByProgramIdOrderByProgramStageIdAcs(programApplicationRequest.getProgramId());
        if (programStageList.isEmpty())
            return null;

        if (programApplicationId!=null){
            ProgramApplication programApplication=programApplicationRepository.findById(programApplicationId)
                    .orElseThrow(() -> new NullPointerException("No Program Application -"+programApplicationId));
//            //get new apply stage
//            ApplyStage applyStage =applyStageRepository.findById(applyStageId)
//                    .orElseThrow(() -> new NullPointerException("No Apply Stage -"+applyStageId));
//            //set status and save old apply stage
//            ApplyStage oldApplyStage=applyStageRepository
//                    .getApplyStageByProgramApplicationProgramApplicationIdAndStatus(programApplication.getProgramApplicationId(),1);
//            oldApplyStage.setStatus(2);
//            oldApplyStage.setUpdateDate(new Date(System.currentTimeMillis()));
//            oldApplyStage.setProgramApplication(programApplication);
//            applyStageRepository.save(oldApplyStage);
//            //set status and save new apply stage
//            applyStage.setStatus(1);
//            applyStage.setUpdateDate(new Date(System.currentTimeMillis()));
//            applyStage.setProgramApplication(programApplication);
//            applyStageRepository.save(applyStage);
            MergeRequest.mergeIgnoreNullValue(programApplicationRequest,programApplication);
            programApplication.setUpdateDate(new Date(System.currentTimeMillis()));
            return ProgramApplicationMapper.INSTANCE.toDto(
                    //programApplicationRepository.save(programApplication)
                    programApplication
            );
        }
        else {
            programApplicationRequest.setStatus(0);
            ProgramApplication resultProgramApplication=programApplicationRepository.save(ProgramApplicationMapper.INSTANCE.toEntity(programApplicationRequest));
            //create and save list apply stage
            for (ProgramStage programStage:programStageList){
                ApplyStage applyStage =new ApplyStage();
                applyStage.setProgramApplication(resultProgramApplication);
                applyStage.setProgramStage(programStage);
                if (programStage.getProgramStageId()==programStageList.get(0).getProgramStageId())
                    applyStage.setStatus(1);
                else
                    applyStage.setStatus(0);
                applyStage.setUpdateDate(new Date(System.currentTimeMillis()));
                applyStageRepository.save(applyStage);
            }
            return ProgramApplicationMapper.INSTANCE.toDto(
                    resultProgramApplication
            );
        }
    }

    @Override
    public List<ProgramApplicationDto> getByCustomerId(Integer id) {
        List<ProgramApplication> programApplications = programApplicationRepository.getProgramApplicationByCustomerId(id);
        return programApplications.stream()
                .map(ProgramApplicationDto::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProgramApplicationDto> getByStaffId(Integer id) {
        return programApplicationRepository.getAllByStaffId(id)
                .stream().map(ProgramApplicationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
