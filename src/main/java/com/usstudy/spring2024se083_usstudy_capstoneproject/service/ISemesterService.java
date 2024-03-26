package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.SemesterDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Semester;

import java.util.List;
import java.util.Optional;

public interface ISemesterService {
    List<SemesterDto> getAllSemester();
    Optional findSemesterById(int id);
}
