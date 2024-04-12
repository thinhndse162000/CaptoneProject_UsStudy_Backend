package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramApplicationDto;

import java.util.List;
import java.util.Optional;

public interface ProgramApplicationService {
    Optional getById(Integer id);

    List<ProgramApplicationDto> getAllFilter();

    Optional getByStudentProfileId(Integer id);

    ProgramApplicationDto saveProgramApplication(ProgramApplicationDto programApplicationDto, Integer stageNo);

    List<ProgramApplicationDto> getByCustomerId(Integer id);
}
