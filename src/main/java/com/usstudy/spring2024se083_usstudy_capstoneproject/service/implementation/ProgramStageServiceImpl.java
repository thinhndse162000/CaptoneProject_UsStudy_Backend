package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramStageDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramStageMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramStageRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramStageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramStageServiceImpl implements ProgramStageService {
    private final ProgramStageRepository programStageRepository;

    @Override
    public Optional findByProgramStageId(Integer id) {
        return programStageRepository.findById(id).map(ProgramStageMapper.INSTANCE::toDto);
    }

    @Override
    public List<ProgramStageDto> findByProgramId(Integer id, Integer stageNo) {
        if (id!=null && stageNo!=null){

            List<ProgramStageDto> resultList=programStageRepository
                    .getProgramStageByProgramProgramIdOrderByProgramStageIdAcs(id)
                    .stream().map(ProgramStageMapper.INSTANCE::toDto).collect(Collectors.toList());

            ProgramStageDto result=resultList.get(stageNo);

            resultList.clear();
            resultList.add(result);

            return resultList;
        }
        if (id!=null){
            return programStageRepository.getProgramStageByProgramProgramIdOrderByProgramStageIdAcs(id)
                    .stream().map(ProgramStageMapper.INSTANCE::toDto).collect(Collectors.toList());
        }
        else {
            return programStageRepository.findAll().stream()
                    .map(ProgramStageMapper.INSTANCE::toDto).collect(Collectors.toList());
        }
    }
}
