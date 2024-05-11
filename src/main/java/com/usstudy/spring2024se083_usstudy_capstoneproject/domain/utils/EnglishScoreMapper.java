package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CertificateTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.EnglishScoreDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.CertificateType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.EnglishScore;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnglishScoreMapper {
    EnglishScoreMapper INSTANCE= Mappers.getMapper(EnglishScoreMapper.class);
    @Mapping(target = "studentProfileId",source = "englishScore.studentProfile.studentProfileId")
    @Mapping(target = "certificateTypeDto",source = "englishScore.certificateType",qualifiedByName = "MapCertificateType")
    EnglishScoreDto toDto(EnglishScore englishScore);
    @Named("MapCertificateType")
    default CertificateTypeDto mapCertificateType(CertificateType certificateType){
        return CertificateTypeMapper.INSTANCE.toDto(certificateType);
    }
}
