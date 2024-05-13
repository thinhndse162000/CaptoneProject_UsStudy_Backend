package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.SchoolProfileRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SchoolProfileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.SchoolProfile;

import java.util.List;

public interface SchoolProfileService {
    List<SchoolProfileDto> getAll();
    SchoolProfileDto getById(Integer id);
    SchoolProfileDto saveSchoolProfile(SchoolProfileRequest schoolProfileRequest);
}
