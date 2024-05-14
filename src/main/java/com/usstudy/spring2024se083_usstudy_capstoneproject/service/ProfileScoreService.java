package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProfileScoreRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProfileScoreDto;

import java.util.List;

public interface ProfileScoreService {
    List<ProfileScoreDto> getAll();
    ProfileScoreDto getById(Integer id);
    ProfileScoreDto saveProfileScore(ProfileScoreRequest profileScoreRequest,Integer id);
    void saveListProfileScore(List<ProfileScoreRequest> profileScoreRequests);
}
