package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ConsultantDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsultantMapper {
    public ConsultantMapper INSTANT = Mappers.getMapper(ConsultantMapper.class);

    ConsultantDto consultantToConsultantDto(Consultant consultant);
}
