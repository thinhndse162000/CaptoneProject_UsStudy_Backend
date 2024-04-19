package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.UniversityFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.UniversityRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;

import java.util.List;
import java.util.Optional;

public interface IUniversityService {
    List<UniversityDto> getAllUniversity();

    Optional getUniversityById(int id);

    UniversityDto saveUniversity(UniversityRequest universityRequest,Integer id);

    List<UniversityDto> getUniversityByTypeId(Integer typeid);

    List<UniversityDto> getUniversityByStateId(Integer stateId);

    List<UniversityDto> getUniversityByRequest(UniversityFilterRequest request);
}
