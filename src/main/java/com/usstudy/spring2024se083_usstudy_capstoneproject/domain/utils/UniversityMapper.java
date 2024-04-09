package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.State;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UniversityType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UniversityMapper {
    UniversityMapper INSTANCE= Mappers.getMapper(UniversityMapper.class);
    @Mapping(target = "universityTypeId",source = "university.universityType.universityTypeId")
    @Mapping(target = "stateId",source = "university.state.stateId")
    UniversityDto universityToUniversityDto(University university);
    @Mapping(target = "universityType",source = "universityTypeId",qualifiedByName = "MapUniversityType")
    @Mapping(target = "state",source = "stateId",qualifiedByName = "MapState")
    University universityDtoToUniversity(UniversityDto universityDto);

    @Named("MapUniversityType")
    default UniversityType mapType(Integer id){
        UniversityType universityType=new UniversityType();
        universityType.setUniversityTypeId(id);
        return universityType;
    }
    @Named("MapState")
    default State mapState(Integer id){
        State state=new State();
        state.setStateId(id);
        return state;
    }
}
