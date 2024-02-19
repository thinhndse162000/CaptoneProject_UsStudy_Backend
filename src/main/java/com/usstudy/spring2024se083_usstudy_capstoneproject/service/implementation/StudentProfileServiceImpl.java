package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.FileUpload;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.FileUploadRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.StudentProfileRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;
    private final FileUploadRepository fileUploadRepository;

    @Autowired
    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository, FileUploadRepository fileUploadRepository){
        this.studentProfileRepository = studentProfileRepository;
        this.fileUploadRepository = fileUploadRepository;
    }

    @Override
    public void CreateStudentProfile(StudentProfileCreateRequest request) {
        
        StudentProfile studentProfile= new StudentProfile();
        FileUpload fileUpload = new FileUpload();

        studentProfile.setStudentProfileId(0);
        studentProfile.setCreateDate(new Date(System.currentTimeMillis()));
        studentProfile.setNationalId(request.getNationalId());
        studentProfile.setPlaceOfBirth(request.getPlaceOfBirth());
        studentProfile.setFullName(request.getFullName());
        studentProfile.setEmail(request.getEmail());
        studentProfile.setPhone(request.getPhone());
        studentProfile.setAddress(request.getAddress());
        studentProfile.setDateOfBirth(request.getDateOfBirth());
        studentProfile.setGender(request.getGender());
        studentProfile.setStudyProcess(request.getStudyProcess().trim());
        studentProfile.setCustomerId(2);
        for (String file : request.getFileString()){
            fileUpload.setUploadFileId(0);
            fileUpload.setStudentProfileId(studentProfile.getStudentProfileId());
            fileUpload.setFileAttach(file);
            fileUploadRepository.save(fileUpload);
        }
        studentProfileRepository.save(studentProfile);
    }

    @Override
    public void UpdateStudentProfile(Integer studentProfileId, StudentProfileUpdateRequest request) {
        StudentProfile studentProfile = studentProfileRepository.findById(studentProfileId)
                .orElseThrow(() -> new NullPointerException("Account not found - " + studentProfileId));

        studentProfile.setEmail(request.getEmail());
        studentProfile.setAddress(request.getAddress());
        studentProfile.setGender(request.getGender());
        studentProfile.setStudyProcess(request.getStudyProcess());
        studentProfile.setPhone(request.getPhone());
        studentProfile.setPlaceOfBirth(request.getPlaceOfBirth());
        studentProfile.setNationalId(request.getNationalId());
        studentProfile.setFullName(request.getFullName());
        studentProfile.setCreateDate(new Date(System.currentTimeMillis()));
        studentProfileRepository.save(studentProfile);
    }

    @Override
    public Iterable<StudentProfile> getAllByCustomerId(Integer customerId) {
        return studentProfileRepository.findByCustomerId(customerId);
    }
}
