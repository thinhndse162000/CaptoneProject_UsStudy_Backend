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
public class ProgramService implements IProgramService {
    private final ProgramRepository programRepository;

    @Override
    public List<Program> getAllProgram() {
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
}
