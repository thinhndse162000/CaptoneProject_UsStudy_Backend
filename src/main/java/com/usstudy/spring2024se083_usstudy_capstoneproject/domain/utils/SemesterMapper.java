package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.SemesterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SemesterDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Semester;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SemesterMapper {
    SemesterMapper INSTANCE= Mappers.getMapper(SemesterMapper.class);
    SemesterDto toDto(Semester semester);
    Semester toEntity(SemesterRequest semesterRequest);
}
