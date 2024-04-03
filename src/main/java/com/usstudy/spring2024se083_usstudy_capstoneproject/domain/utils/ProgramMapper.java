package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProgramMapper {

    ProgramMapper INSTANT = Mappers.getMapper(ProgramMapper.class);

    @Mapping(target = "universityId", source = "program.university.universityId")
    @Mapping(target = "majorId", source = "program.major.majorId")
    @Mapping(target = "semesterId", source = "program.semester.semesterId")
    @Mapping(target = "programTypeId", source = "program.programType.programTypeId")
    ProgramDto programToProgramDto(Program program);
}
