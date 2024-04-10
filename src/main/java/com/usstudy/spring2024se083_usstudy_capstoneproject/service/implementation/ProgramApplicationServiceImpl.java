package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplyStateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramApplicationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramStageDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
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
    public Optional getByStudentProfileId(Integer id) {
        return programApplicationRepository.findByStudentProfileStudentProfileId(id)
                .map(ProgramApplicationMapper.INSTANCE::toDto);
    }

    @Override
    public ProgramApplicationDto saveProgramApplication(ProgramApplicationDto programApplicationDto,Integer stageNo) {
        List<ProgramStage> programStageList =
                programStageRepository.getProgramStageByProgramIdOrderByProgramStageIdAcs(programApplicationDto.getProgramId());
        ProgramStageDto programStageDto;

        try{
            if (stageNo!=null){
                programStageDto= ProgramStageMapper.INSTANCE.toDto(programStageList.get(stageNo));
            }
            else {
                programStageDto= ProgramStageMapper.INSTANCE.toDto(programStageList.get(0));
            }
        } catch (IndexOutOfBoundsException ex){
            return null;
        } catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }

        ApplyStateDto saveApplyStage=new ApplyStateDto();
        saveApplyStage.setProgramStageId(programStageDto.getProgramStageId());
        saveApplyStage.setUpdateDate(programApplicationDto.getUpdateDate());

        ApplyStateDto resultApplyState= ApplyStageMapper.INSTANCE.toDto(
                applyStageRepository.save(ApplyStageMapper.INSTANCE.toEntity(saveApplyStage))
        );
        programApplicationDto.setApplyStageId(resultApplyState.getApplyStageId());
        return ProgramApplicationMapper.INSTANCE.toDto(
                programApplicationRepository.save(ProgramApplicationMapper.INSTANCE.toEntity(programApplicationDto))
        );
    }
}
