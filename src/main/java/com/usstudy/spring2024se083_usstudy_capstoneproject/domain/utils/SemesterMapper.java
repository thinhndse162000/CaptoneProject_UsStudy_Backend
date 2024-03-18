package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SemesterDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Semester;
import org.mapstruct.Mapper;

@Mapper
public interface SemesterMapper {
    SemesterDto semesterToSemesterDto(Semester semester);
}
