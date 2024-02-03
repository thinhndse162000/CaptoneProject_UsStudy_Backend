package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;

import java.util.List;
import java.util.Optional;

public interface IUniversityService {
    List<University> getAllUniversity();
    Optional getUniversityById(int id);
    University saveUniversity(University university);
}
