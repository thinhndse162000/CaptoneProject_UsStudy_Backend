package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramStageDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ProgramMapper {
    ProgramMapper INSTANCE= Mappers.getMapper(ProgramMapper.class);
    @Mapping(target = "universityId",source = "program.university.universityId")
    @Mapping(target = "majorId",source = "program.major.majorId")
    @Mapping(target = "semesterId",source = "program.semester.semesterId")
    @Mapping(target = "programTypeId",source = "program.programType.programTypeId")
    @Mapping(target = "programStageDtos",source = "program.programStages",qualifiedByName = "MapProgramStageDto")
    ProgramDto programToProgramDto(Program program);
    @Mapping(target = "university",source = "universityId",qualifiedByName = "MapUniversity")
    @Mapping(target = "major",source = "majorId",qualifiedByName = "MapMajor")
    @Mapping(target = "semester",source = "semesterId",qualifiedByName = "MapSemester")
    @Mapping(target = "programType",source = "programTypeId",qualifiedByName = "MapProgramType")
    Program toEntity(ProgramRequest programRequest);
    @Named("MapProgramStageDto")
    default List<ProgramStageDto> mapProgramStageDto(List<ProgramStage> programStages){
        if (programStages==null)
            return null;
        return programStages.stream().map(ProgramStageMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
    @Named("MapUniversity")
    default University mapUniversity(Integer id){
        University university=new University();
        university.setUniversityId(id);
        return university;
    }
    @Named("MapMajor")
    default Major mapMajor(Integer id){
        Major major=new Major();
        major.setMajorId(id);
        return major;
    }
    @Named("MapSemester")
    default Semester mapSemester(Integer id){
        Semester semester=new Semester();
        semester.setSemesterId(id);
        return semester;
    }
    @Named("MapProgramType")
    default ProgramType mapProgramType(Integer id){
        ProgramType programType=new ProgramType();
        programType.setProgramTypeId(id);
        return programType;
    }
}
