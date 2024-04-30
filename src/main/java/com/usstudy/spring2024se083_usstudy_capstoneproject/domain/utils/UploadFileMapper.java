package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UploadFileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UploadFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UploadFileMapper {
    UploadFileMapper INSTANCE= Mappers.getMapper(UploadFileMapper.class);
    @Mapping(target = "studentProfileId",source = "uploadFile.studentProfile.studentProfileId")
    UploadFileDto toDto(UploadFile uploadFile);
}
