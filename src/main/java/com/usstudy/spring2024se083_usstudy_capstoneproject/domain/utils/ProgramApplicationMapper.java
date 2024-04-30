package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramApplicationRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplyStageDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramApplicationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ProgramApplicationMapper {
    ProgramApplicationMapper INSTANCE= Mappers.getMapper(ProgramApplicationMapper.class);
    @Mapping(target = "studentProfileId",source = "programApplication.studentProfile.studentProfileId")
    @Mapping(target = "programId",source = "programApplication.program.programId")
    @Mapping(target = "applyStage",source = "programApplication.applyStages",qualifiedByName = "MapApplyStageList")
    ProgramApplicationDto toDto(ProgramApplication programApplication);
    @Mapping(target = "studentProfile",source = "studentProfileId",qualifiedByName = "MapStudentProfile")
    @Mapping(target = "program",source = "programId",qualifiedByName = "MapProgram")
    //@Mapping(target = "applyStage",source = "applyStageId",qualifiedByName = "MapApplyStage")
    ProgramApplication toEntity(ProgramApplicationRequest programApplicationRequest);
    @Named("MapProgram")
    default Program mapProgram(Integer id){
        Program program=new Program();
        program.setProgramId(id);
        return program;
    }
    @Named("MapStudentProfile")
    default StudentProfile mapStudentProfile(Integer id){
        StudentProfile studentProfile=new StudentProfile();
        studentProfile.setStudentProfileId(id);
        return studentProfile;
    }
    @Named("MapApplyStageList")
    default List<ApplyStageDto> mapApplyStageList(List<ApplyStage> applyStages){
        List<ApplyStageDto> list=applyStages.stream().map(ApplyStageMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
        return list;
    }
}
