package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CertificateTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.CertificateType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CertificateTypeMapper {
    CertificateTypeMapper INSTANCE= Mappers.getMapper(CertificateTypeMapper.class);
    CertificateTypeDto toDto(CertificateType certificateType);
}
