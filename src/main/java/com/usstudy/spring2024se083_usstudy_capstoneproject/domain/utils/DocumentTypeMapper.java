package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.DocumentTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.DocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentTypeMapper {
    DocumentTypeMapper INSTANCE= Mappers.getMapper(DocumentTypeMapper.class);
    DocumentTypeDto toDto(DocumentType documentType);
}
