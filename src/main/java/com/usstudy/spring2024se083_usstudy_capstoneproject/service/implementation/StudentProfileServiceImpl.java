package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StudentProfileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.UploadFile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.StudentProfileMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.CustomerRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.FileUploadRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.StudentProfileRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;

    private final CustomerRepository customerRepository;
    private final FileUploadRepository fileUploadRepository;

    @Autowired
    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository, CustomerRepository customerRepository, FileUploadRepository fileUploadRepository) {
        this.studentProfileRepository = studentProfileRepository;
        this.customerRepository = customerRepository;
        this.fileUploadRepository = fileUploadRepository;
    }

    @Override
    public void CreateStudentProfile(StudentProfileCreateRequest request) {

        StudentProfile studentProfile = new StudentProfile();
        UploadFile fileUpload = new UploadFile();
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new NullPointerException("Customer not found - " + request.getCustomerId()));
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
        studentProfile.setCustomer(customer);
        studentProfile.setImg(request.getImg());

        studentProfileRepository.save(studentProfile);

        if (!(request.getFileString() == null)) {
            for (String file : request.getFileString()) {
                fileUpload.setUploadFileId(0);
                fileUpload.setStudentProfile(studentProfile);
                fileUpload.setFileAttach(file);
                fileUploadRepository.save(fileUpload);
            }
        }
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
    public Iterable<StudentProfileDto> getAllByCustomerId(Integer customerId) {
        return studentProfileRepository.findByCustomerId(customerId)
                .stream().map(StudentProfileMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentProfileDto> getById(Integer id) {

        return studentProfileRepository.findById(id).map(StudentProfileMapper.INSTANCE::toDto);
    }
}
