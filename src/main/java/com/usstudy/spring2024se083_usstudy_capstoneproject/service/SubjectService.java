package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SubjectDto;

import java.util.List;

public interface SubjectService {
    List<SubjectDto> getAll();
    SubjectDto getById(Integer id);
}
