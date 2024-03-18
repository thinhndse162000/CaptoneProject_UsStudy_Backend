package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UniversityType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.UniversityTypeMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.UniversityTypeRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IUniversityTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UniversityTypeServiceImpl implements IUniversityTypeService {
    private final UniversityTypeRepository universityTypeRepository;
    private final UniversityTypeMapper universityTypeMapper;

    @Override
    public List<UniversityTypeDto> getAllUniversityType() {
        return universityTypeRepository.findAll()
                .stream().map(universityTypeMapper::universityTypeToUniversityTypeDto).collect(Collectors.toList());
    }

    @Override
    public Optional getUniversityTypeById(int id) {
        return universityTypeRepository.findById(id).map(universityTypeMapper::universityTypeToUniversityTypeDto);
    }
}
