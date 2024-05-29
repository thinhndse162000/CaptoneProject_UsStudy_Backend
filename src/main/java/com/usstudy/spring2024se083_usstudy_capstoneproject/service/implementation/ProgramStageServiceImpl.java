package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramStageProgramFeeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramStageRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramStageDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramFee;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramFeeMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramStageMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramFeeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramStageRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramStageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramStageServiceImpl implements ProgramStageService {
    private final ProgramStageRepository programStageRepository;
    private final ProgramFeeRepository programFeeRepository;

    @Override
    public Optional findByProgramStageId(Integer id) {
        return programStageRepository.findById(id).map(ProgramStageMapper.INSTANCE::toDto);
    }

    @Override
    public List<ProgramStageDto> findByProgramId(Integer id, Integer stageNo) {
        if (id!=null && stageNo!=null){

            List<ProgramStageDto> resultList=programStageRepository
                    .getProgramStageByProgramIdOrderByProgramStageIdAcs(id)
                    .stream().map(ProgramStageMapper.INSTANCE::toDto).collect(Collectors.toList());

            ProgramStageDto result=resultList.get(stageNo);

            resultList.clear();
            resultList.add(result);

            return resultList;
        }
        if (id!=null){
            return programStageRepository.getProgramStageByProgramIdOrderByProgramStageIdAcs(id)
                    .stream().map(ProgramStageMapper.INSTANCE::toDto).collect(Collectors.toList());
        }
        else {
            return programStageRepository.findAll().stream()
                    .map(ProgramStageMapper.INSTANCE::toDto).collect(Collectors.toList());
        }
    }

    @Override
    public ProgramStageDto saveProgramStage(ProgramStageRequest programStageRequest) {
        return ProgramStageMapper.INSTANCE.toDto(
                programStageRepository.save(ProgramStageMapper.INSTANCE.toEntity(programStageRequest))
        );
    }

    @Override
    public List<ProgramStageDto> saveListProgram(List<ProgramStageRequest> programStageRequestList) {
        List<ProgramStageDto> result=new ArrayList<>();
        for (ProgramStageRequest programStageRequest:programStageRequestList){
            result.add(ProgramStageMapper.INSTANCE.toDto(
                    programStageRepository.save(ProgramStageMapper.INSTANCE.toEntity(programStageRequest))
            ));
        }
        return result;
    }

    @Override
    public List<ProgramStageDto> saveListProgramStageFee(List<ProgramStageProgramFeeRequest> requestList) {
        List<ProgramStageDto> result=new ArrayList<>();
        for (ProgramStageProgramFeeRequest request:requestList){
            if (request.getProgramFeeRequest()!=null){
                //save programFee
                ProgramFee programFee= ProgramFeeMapper.INSTANCE.toEntity(request.getProgramFeeRequest());
                ProgramFee resultFee=programFeeRepository.save(programFee);
                //Set programFeeId
                ProgramStage programStage=ProgramStageMapper.INSTANCE.toEntity(request.getProgramStageRequest());
                programStage.setProgramFeeId(resultFee.getProgramFeeId());
                //save program stage
                result.add(ProgramStageMapper.INSTANCE.toDto(
                        programStageRepository.save(programStage)
                ));
            }
            else {
                ProgramStage programStage=ProgramStageMapper.INSTANCE.toEntity(request.getProgramStageRequest());
                //save program stage
                result.add(ProgramStageMapper.INSTANCE.toDto(
                        programStageRepository.save(programStage)
                ));
            }
        }
        return result;
    }
}
