package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.FileUpload;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.FileUploadRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final FileUploadRepository fileUploadRepository;

    @Autowired
    public FileUploadServiceImpl(FileUploadRepository fileUploadRepository) {
        this.fileUploadRepository = fileUploadRepository;
    }

    @Override
    public void createFileUpload(ArrayList<StudentProfileCreateRequest> requests) {
        FileUpload fileUpload = new FileUpload();

    }
}
