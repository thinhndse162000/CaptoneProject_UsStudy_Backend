package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProgramTypeMapper {
    ProgramTypeMapper INSTANCE= Mappers.getMapper(ProgramTypeMapper.class);
    ProgramTypeDto toDto(ProgramType programType);
}
