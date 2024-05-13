package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProfileScoreRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProfileScoreDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SubjectDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ProfileScore;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.SchoolProfile;
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
    @Mapping(target = "schoolProfile",source = "schoolProfileId",qualifiedByName = "MapSchoolProfile")
    @Mapping(target = "subject",source = "subjectId",qualifiedByName = "MapSubject")
    ProfileScore toEntity(ProfileScoreRequest profileScoreRequest);
    @Named("MapProfileScoreDto")
    default SubjectDto mapProfileScoreDto(Subject subject){
        return SubjectMapper.INSTANCE.toDto(subject);
    }
    @Named("MapSchoolProfile")
    default SchoolProfile mapSchoolProfile(Integer id){
        SchoolProfile schoolProfile=new SchoolProfile();
        schoolProfile.setSchoolProfileId(id);
        return schoolProfile;
    }
    @Named("MapSubject")
    default Subject mapSubject(Integer id){
        Subject subject=new Subject();
        subject.setSubjectId(id);
        return subject;
    }
}
