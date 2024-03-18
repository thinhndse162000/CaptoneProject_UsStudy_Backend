package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramType;
import org.mapstruct.Mapper;

@Mapper
public interface ProgramTypeMapper {
    ProgramTypeDto programTypeToProgramTypeDto(ProgramType programType);
}
