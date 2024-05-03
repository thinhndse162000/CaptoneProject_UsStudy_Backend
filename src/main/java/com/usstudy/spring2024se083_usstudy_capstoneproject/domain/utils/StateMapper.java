package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.State;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StateMapper {
    StateMapper INSTANCE= Mappers.getMapper(StateMapper.class);
    StateDto stateToStateDto(State state);
}
