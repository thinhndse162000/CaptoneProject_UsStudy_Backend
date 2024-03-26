package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UniversityType;

import java.util.List;
import java.util.Optional;

public interface IUniversityTypeService {
    List<UniversityTypeDto> getAllUniversityType();
    Optional getUniversityTypeById(int id);
}
