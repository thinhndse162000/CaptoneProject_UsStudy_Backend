package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.repository.ProgramRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.IProgramService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ProgramService implements IProgramService {
    private final ProgramRepository programRepository;
}
