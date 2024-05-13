package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProfileScoreDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SchoolProfileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProfileScore;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.SchoolProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface SchoolProfileMapper {
    SchoolProfileMapper INSTANCE= Mappers.getMapper(SchoolProfileMapper.class);
    @Mapping(target = "studentProfileId",source = "schoolProfile.studentProfile.studentProfileId")
    @Mapping(target = "profileScoreDtos",source = "schoolProfile.profileScores",qualifiedByName = "MapProfileScoreDto")
    SchoolProfileDto toDto(SchoolProfile schoolProfile);
    @Named("MapProfileScoreDto")
    default List<ProfileScoreDto> mapProfileScoreDto(List<ProfileScore> profileScores){
        return profileScores.stream().map(ProfileScoreMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
