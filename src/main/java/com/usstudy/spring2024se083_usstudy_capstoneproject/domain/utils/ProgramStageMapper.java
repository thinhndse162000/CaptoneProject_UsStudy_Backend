package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramStageDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramStage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
@Mapper
public interface ProgramStageMapper {
    ProgramStageMapper INSTANCE= Mappers.getMapper(ProgramStageMapper.class);
    @Mapping(target = "programId",source = "programStage.program.programId")
    ProgramStageDto toDto(ProgramStage programStage);
    @Mapping(target = "program",source = "programId",qualifiedByName = "MapProgram")
    ProgramStage toEntity(ProgramStageDto programStageDto);
    @Named("MapProgram")
    default Program mapProgram(Integer id){
        Program program=new Program();
        program.setProgramId(id);
        return program;
    }
}
