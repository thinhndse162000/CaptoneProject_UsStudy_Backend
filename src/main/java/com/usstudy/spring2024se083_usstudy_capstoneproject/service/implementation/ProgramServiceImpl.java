package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramServiceImpl implements IProgramService {
    private final ProgramRepository programRepository;

    @Override
    public Iterable<Program> getAllProgram() {
        return programRepository.findAll();
    }

    @Override
    public Optional<Program> getProgramById(int id) {
        return programRepository.findById(id);
    }

    @Override
    public Program saveProgram(Program program) {
        programRepository.save(program);
        return program;
    }

    @Override
    public List<Program> getProgramsByUniversityId(int id) {
        return programRepository.getProgramsByUniversityId(id);
    }

    @Override
    public List<Program> getProgramsByMajorId(int id) {
        return programRepository.getProgramsByMajorId(id);
    }

    @Override
    public List<Program> getProgramsByUniversityIdAndMajorId(int universityId, int majorId) {
        return programRepository.getProgramsByUniversityIdAndMajorId(universityId, majorId);
    }

    @Override
    public List<Program> getProgramsByProgramName(String programName) {
        return programRepository.getProgramsByNameProgramContains(programName);
    }

    @Override
    public List<Program> getProgramsByProgramTypeId(Integer programTypeId) {
        return programRepository.getProgramByProgramTypeId(programTypeId);
    }

    @Override
    public List<Program> getProgrramsBySemesterId(Integer semesterId) {
        return programRepository.getProgramBySemesterId(semesterId);
    }
}
