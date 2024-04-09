package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;


import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ApplyStateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApplyStageMapper {
    ApplyStageMapper INSTANCE= Mappers.getMapper(ApplyStageMapper.class);
    @Mapping(target = "programStageId",source = "applyStage.programStage.programStageId")
    ApplyStateDto toDto(ApplyStage applyStage);
}
