package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StudentProfileDto;

import java.util.List;
import java.util.Optional;

public interface StudentProfileService {
    StudentProfileDto CreateStudentProfile(StudentProfileCreateRequest request);

    StudentProfileDto UpdateStudentProfile(Integer studentProfileId, StudentProfileUpdateRequest request);

    Iterable<StudentProfileDto> getAllByCustomerId(Integer customerId);

    Optional<StudentProfileDto> getById(Integer id);

    List<StudentProfileDto> getAll();
}
