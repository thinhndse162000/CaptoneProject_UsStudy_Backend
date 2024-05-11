package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.EnglishScoreRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.EnglishScoreDto;

import java.util.List;

public interface EnglishScoreService {
    List<EnglishScoreDto> getAll();
    EnglishScoreDto getById(Integer id);
    EnglishScoreDto saveEnglishScore(EnglishScoreRequest englishScoreRequest,Integer id);
}
