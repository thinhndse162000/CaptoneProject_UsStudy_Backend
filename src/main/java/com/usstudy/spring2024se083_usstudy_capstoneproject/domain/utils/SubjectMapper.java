package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SubjectDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectMapper {
    SubjectMapper INSTANCE= Mappers.getMapper(SubjectMapper.class);
    SubjectDto toDto(Subject subject);
}
