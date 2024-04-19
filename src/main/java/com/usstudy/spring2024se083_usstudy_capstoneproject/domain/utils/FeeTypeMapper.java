package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.FeeTypeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.FeeTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.FeeType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FeeTypeMapper {
    FeeTypeMapper INSTANCE= Mappers.getMapper(FeeTypeMapper.class);
    FeeTypeDto toDto(FeeType feeType);
    FeeType toEntity(FeeTypeRequest feeTypeRequest);
}
