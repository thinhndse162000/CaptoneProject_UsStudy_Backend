package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.repository.UniversityTypeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.IUniversityTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UniversityTypeService implements IUniversityTypeService {
    private final UniversityTypeRepository universityTypeRepository;
}
