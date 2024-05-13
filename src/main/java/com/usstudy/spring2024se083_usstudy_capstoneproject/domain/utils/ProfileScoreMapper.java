package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProfileScoreDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SubjectDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProfileScore;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileScoreMapper {
    ProfileScoreMapper INSTANCE= Mappers.getMapper(ProfileScoreMapper.class);
    @Mapping(target = "subjectDto",source = "profileScore.subject",qualifiedByName = "MapProfileScoreDto")
    @Mapping(target = "schoolProfileId",source = "profileScore.schoolProfile.schoolProfileId")
    ProfileScoreDto toDto(ProfileScore profileScore);

    @Named("MapProfileScoreDto")
    default SubjectDto mapProfileScoreDto(Subject subject){
        return SubjectMapper.INSTANCE.toDto(subject);
    }
}
