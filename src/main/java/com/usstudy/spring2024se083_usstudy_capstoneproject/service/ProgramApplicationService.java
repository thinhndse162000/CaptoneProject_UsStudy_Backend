package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramApplicationRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramApplicationDto;

import java.util.List;
import java.util.Optional;

public interface ProgramApplicationService {
    Optional getById(Integer id);

    List<ProgramApplicationDto> getAllFilter();

    List<ProgramApplicationDto> getByStudentProfileId(Integer id);

    ProgramApplicationDto saveProgramApplication(ProgramApplicationRequest programApplicationRequest,Integer programApplicationId);

    List<ProgramApplicationDto> getByCustomerId(Integer id);
    List<ProgramApplicationDto> getByStaffId(Integer id);
}
