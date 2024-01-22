package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.repository.UniversityRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.IUniversityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UniversityService implements IUniversityService {
    private final UniversityRepository universityRepository;

}
