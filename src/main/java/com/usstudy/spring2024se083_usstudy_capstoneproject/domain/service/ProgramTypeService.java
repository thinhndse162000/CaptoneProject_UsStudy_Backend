package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.repository.ProgramTypeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.IProgramTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramTypeService implements IProgramTypeService {
    private final ProgramTypeRepository programTypeRepository;

    @Override
    public List<ProgramType> getAllProgramType() {
        return programTypeRepository.findAll();
    }

    @Override
    public Optional getProgramTypeById(int id) {
        return programTypeRepository.findById(id);
    }
}
