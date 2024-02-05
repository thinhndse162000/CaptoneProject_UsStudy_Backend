package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;

import java.util.ArrayList;

public interface FileUploadService {
    void createFileUpload(ArrayList<StudentProfileCreateRequest> requests);
}
