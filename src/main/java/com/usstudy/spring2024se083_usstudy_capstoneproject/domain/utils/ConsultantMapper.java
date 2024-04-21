package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ConsultantRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ConsultantDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsultantMapper {
    ConsultantMapper INSTANT = Mappers.getMapper(ConsultantMapper.class);
    @Mapping(target = "userName",source = "username")
    ConsultantDto consultantToConsultantDto(Consultant consultant);
    @Mapping(target = "userName",source = "userName")
    Consultant toEntity(ConsultantRequest consultantRequest);
}
