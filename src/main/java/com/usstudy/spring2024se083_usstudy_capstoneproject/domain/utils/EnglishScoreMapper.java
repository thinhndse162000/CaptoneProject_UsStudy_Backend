package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.EnglishScoreRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CertificateTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.EnglishScoreDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.CertificateType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.EnglishScore;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnglishScoreMapper {
    EnglishScoreMapper INSTANCE= Mappers.getMapper(EnglishScoreMapper.class);
    @Mapping(target = "studentProfileId",source = "englishScore.studentProfile.studentProfileId")
    @Mapping(target = "certificateTypeDto",source = "englishScore.certificateType",qualifiedByName = "MapCertificateTypeDto")
    EnglishScoreDto toDto(EnglishScore englishScore);
    @Mapping(target = "studentProfile",source = "studentProfileId",qualifiedByName = "MapStudentProfile")
    @Mapping(target = "certificateType",source = "certificateTypeId",qualifiedByName = "MapCertificateType")
    EnglishScore toEntity(EnglishScoreRequest englishScoreRequest);
    @Named("MapCertificateTypeDto")
    default CertificateTypeDto mapCertificateTypeDto(CertificateType certificateType){
        return CertificateTypeMapper.INSTANCE.toDto(certificateType);
    }
    @Named("MapCertificateType")
    default CertificateType mapCertificateType(Integer id){
        CertificateType certificateType=new CertificateType();
        certificateType.setCertificateTypeId(id);
        return certificateType;
    }
    @Named("MapStudentProfile")
    default StudentProfile mapStudentProfile(Integer id){
        StudentProfile studentProfile=new StudentProfile();
        studentProfile.setStudentProfileId(id);
        return studentProfile;
    }
}
