package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;

import java.util.List;
import java.util.Optional;

public interface IProgramService {
    List<Program> getAllProgram();
    Optional<Program> getProgramById(int id);
    Program saveProgram(Program program);
    List<Program> getProgramsByUniversityId(int id);
}
