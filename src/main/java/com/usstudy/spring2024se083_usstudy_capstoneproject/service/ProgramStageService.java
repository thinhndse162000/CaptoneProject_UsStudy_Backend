package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramStageDto;

import java.util.List;
import java.util.Optional;

public interface ProgramStageService {
    Optional findByProgramStageId(Integer id);
    List<ProgramStageDto> findByProgramId(Integer id,Integer stageNo);
}
