package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.repository.ProgramTypeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.IProgramTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramTypeService implements IProgramTypeService {
    private final ProgramTypeRepository programTypeRepository;
}
