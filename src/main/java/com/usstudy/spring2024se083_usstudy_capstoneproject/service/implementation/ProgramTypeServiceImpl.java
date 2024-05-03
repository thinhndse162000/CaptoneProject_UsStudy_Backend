package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.ProgramTypeMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramTypeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramTypeServiceImpl implements IProgramTypeService {
    private final ProgramTypeRepository programTypeRepository;

    @Override
    public List<ProgramTypeDto> getAllProgramType() {
        return programTypeRepository.findAll()
                .stream().map(ProgramTypeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional getProgramTypeById(int id) {
        return programTypeRepository.findById(id)
                .map(ProgramTypeMapper.INSTANCE::toDto);
    }
}
