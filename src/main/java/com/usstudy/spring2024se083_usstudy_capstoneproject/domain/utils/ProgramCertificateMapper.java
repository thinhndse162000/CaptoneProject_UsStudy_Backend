package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramCertificateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramCertificateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.CertificateType;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProgramCertificate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProgramCertificateMapper {
    ProgramCertificateMapper INSTANCE = Mappers.getMapper(ProgramCertificateMapper.class);

    @Mapping(target = "programId", source = "programCertificate.program.programId")
    @Mapping(target = "certificateTypeId", source = "programCertificate.certificateType.certificateTypeId")
    ProgramCertificateDto toDto(ProgramCertificate programCertificate);

    @Mapping(target = "program", source = "programId", qualifiedByName = "MapProgram")
    @Mapping(target = "certificateType", source = "certificateTypeId", qualifiedByName = "MapCertificateType")
    ProgramCertificate toEntity(ProgramCertificateRequest request);

    @Named("MapProgram")
    default Program mapProgram(Integer id) {
        Program program = new Program();
        program.setProgramId(id);
        return program;
    }

    @Named("MapCertificateType")
    default CertificateType mapCertificateType(Integer id) {
        CertificateType certificateType = new CertificateType();
        certificateType.setCertificateTypeId(id);
        return certificateType;
    }
}
