package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StaffDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffMapper {
    StaffMapper INSTANCE= Mappers.getMapper(StaffMapper.class);
    StaffDto toDto(Staff staff);
}
