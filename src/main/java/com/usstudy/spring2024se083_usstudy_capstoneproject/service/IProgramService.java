package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;

import java.util.List;
import java.util.Optional;

public interface IProgramService {
    Iterable<ProgramDto> getAllProgram();

    Optional getProgramById(int id);

    ProgramDto saveProgram(ProgramDto programDto);

    List<ProgramDto> getProgramsByUniversityId(int id);

    List<ProgramDto> getProgramsByMajorId(int id);

    List<ProgramDto> getProgramsByUniversityIdAndMajorId(int universityId, int majorId);

    List<ProgramDto> getProgramsByProgramName(String programName);

    List<ProgramDto> getProgramsByProgramTypeId(Integer programTypeId);

    List<ProgramDto> getProgramsBySemesterId(Integer semesterId);
}
