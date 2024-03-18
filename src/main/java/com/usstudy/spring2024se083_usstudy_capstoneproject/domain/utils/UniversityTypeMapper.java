package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UniversityType;
import org.mapstruct.Mapper;

@Mapper
public interface UniversityTypeMapper {
    UniversityTypeDto universityTypeToUniversityTypeDto(UniversityType universityType);
}
