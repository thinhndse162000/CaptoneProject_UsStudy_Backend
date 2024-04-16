package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramApplicationRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramApplicationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramApplication;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProgramApplicationMapper {
    ProgramApplicationMapper INSTANCE= Mappers.getMapper(ProgramApplicationMapper.class);
    @Mapping(target = "studentProfileId",source = "programApplication.studentProfile.studentProfileId")
    @Mapping(target = "programId",source = "programApplication.program.programId")
    @Mapping(target = "applyStageId",source = "programApplication.applyStage.applyStageId")
    ProgramApplicationDto toDto(ProgramApplication programApplication);
    @Mapping(target = "studentProfile",source = "studentProfileId",qualifiedByName = "MapStudentProfile")
    @Mapping(target = "program",source = "programId",qualifiedByName = "MapProgram")
    @Mapping(target = "applyStage",source = "applyStageId",qualifiedByName = "MapApplyStage")
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
    @Named("MapApplyStage")
    default ApplyStage mapApplyStage(Integer id){
        ApplyStage applyStage=new ApplyStage();
        applyStage.setApplyStageId(id);
        return applyStage;
    }
}
