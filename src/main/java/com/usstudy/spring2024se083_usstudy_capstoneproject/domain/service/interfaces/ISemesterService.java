package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Semester;

import java.util.List;
import java.util.Optional;

public interface ISemesterService {
    List<Semester> getAllSemester();
    Optional findSemesterById(int id);
}
