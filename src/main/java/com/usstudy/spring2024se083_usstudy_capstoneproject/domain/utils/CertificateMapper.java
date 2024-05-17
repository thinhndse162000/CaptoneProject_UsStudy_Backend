package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.CertificateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CertificateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CertificateTypeDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Certificate;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.CertificateType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CertificateMapper {
    CertificateMapper INSTANCE = Mappers.getMapper(CertificateMapper.class);
    @Mapping(target = "studentProfileId",source = "certificate.studentProfile.studentProfileId")
    @Mapping(target = "certificateTypeDto",source = "certificate.certificateType",qualifiedByName = "MapCertificateTypeDto")
    CertificateDto toDto(Certificate certificate);

    @Mapping(target = "studentProfile",source = "studentProfileId",qualifiedByName = "MapStudentProfile")
    @Mapping(target = "certificateType",source = "certificateTypeId",qualifiedByName = "MapCertificateType")
    Certificate toEntity(CertificateRequest certificateRequest);
    @Named("MapCertificateTypeDto")
    default CertificateTypeDto mapCertificateTypeDto(CertificateType certificateType){
        if (certificateType==null)
            return null;
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
