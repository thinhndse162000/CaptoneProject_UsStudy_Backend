package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.MajorRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.MajorDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MajorMapper {
    MajorMapper INSTANCE= Mappers.getMapper(MajorMapper.class);
    MajorDto toDto(Major major);
    Major toEntity(MajorRequest majorRequest);
}
