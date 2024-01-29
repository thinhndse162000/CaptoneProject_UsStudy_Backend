package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UniversityType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.repository.UniversityTypeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.IUniversityTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UniversityTypeService implements IUniversityTypeService {
    private final UniversityTypeRepository universityTypeRepository;

    @Override
    public List<UniversityType> getAllUniversityType() {
        return universityTypeRepository.findAll();
    }

    @Override
    public Optional getUniversityTypeById(int id) {
        return universityTypeRepository.findById(id);
    }
}
