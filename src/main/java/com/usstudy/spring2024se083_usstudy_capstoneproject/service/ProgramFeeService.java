package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramFeeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramFeeDto;

import java.util.List;
import java.util.Optional;

public interface ProgramFeeService {
    ProgramFeeDto saveProgramFee(ProgramFeeRequest programFeeRequest,Integer id);
    List<ProgramFeeDto> getAll();
    Optional findById(Integer id);
    List<ProgramFeeDto> findByProgramId(Integer programId);
}
