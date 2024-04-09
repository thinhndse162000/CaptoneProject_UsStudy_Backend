package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;


import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplyStateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramStage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplyStageMapper {
    ApplyStageMapper INSTANCE= Mappers.getMapper(ApplyStageMapper.class);
    @Mapping(target = "programStageId",source = "applyStage.programStage.programStageId")
    ApplyStateDto toDto(ApplyStage applyStage);
    @Mapping(target = "programStage",source = "programStageId",qualifiedByName = "MapProgramStage")
    ApplyStage toEntity(ApplyStateDto applyStateDto);

    @Named("MapProgramStage")
    default ProgramStage mapProgramStage(Integer id){
        ProgramStage programStage=new ProgramStage();
        programStage.setProgramStageId(id);
        return programStage;
    }
}
