package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;

public interface StudentProfileService {
    void CreateStudentProfile(StudentProfileCreateRequest request);

    void UpdateStudentProfile(Integer studentProfileId ,StudentProfileUpdateRequest request);

    Iterable<StudentProfile> getAllByCustomerId(Integer customerId);
}
