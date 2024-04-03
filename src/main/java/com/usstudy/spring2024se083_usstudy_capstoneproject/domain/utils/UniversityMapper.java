package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniversityMapper {
    UniversityMapper INSTANT = Mappers.getMapper(UniversityMapper.class);

    @Mapping(target = "universityTypeId", source = "university.universityType.universityTypeId")
    @Mapping(target = "stateId", source = "university.state.stateId")
    UniversityDto universityToUniversityDto(University university);
}
