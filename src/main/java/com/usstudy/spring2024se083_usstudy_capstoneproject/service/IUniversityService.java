package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;

import java.util.List;
import java.util.Optional;

public interface IUniversityService {
    List<UniversityDto> getAllUniversity();

    Optional getUniversityById(int id);

    UniversityDto saveUniversity(University university);

    List<UniversityDto> getUniversityByTypeId(Integer typeid);

    List<UniversityDto> getUniversityByStateId(Integer stateId);
}
