package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;


import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplyStageDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramStageDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramApplication;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramStage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ApplyStageMapper {
    ApplyStageMapper INSTANCE= Mappers.getMapper(ApplyStageMapper.class);
    @Mapping(target = "programStageId",source = "applyStage.programStage.programStageId")
    @Mapping(target = "programApplicationId",source = "applyStage.programApplication.programApplicationId")
    //@Mapping(target = "programStage",source = "applyStage.programStage",qualifiedByName = "MapProgramStage")
    ApplyStageDto toDto(ApplyStage applyStage);
    @Mapping(target = "programStage",source = "programStageId",qualifiedByName = "MapProgramStageId")
    @Mapping(target = "programApplication",source = "programApplicationId",qualifiedByName = "MapProgramApplication")
    ApplyStage toEntity(ApplyStageDto applyStageDto);

    @Named("MapProgramStageId")
    default ProgramStage mapProgramStage(Integer id){
        ProgramStage programStage=new ProgramStage();
        programStage.setProgramStageId(id);
        return programStage;
    }
    @Named("MapProgramApplication")
    default ProgramApplication mapProgramApplication(Integer id){
        ProgramApplication programApplication=new ProgramApplication();
        programApplication.setProgramApplicationId(id);
        return programApplication;
    }
//    @Named("MapProgramStage")
//    default List<ProgramStageDto> mapProgramStageDto(List<ProgramStage> programStages){
//        List<ProgramStageDto> list=programStages.stream().map(ProgramStageMapper.INSTANCE::toDto).collect(Collectors.toList());
//        return list;
//    }
}
