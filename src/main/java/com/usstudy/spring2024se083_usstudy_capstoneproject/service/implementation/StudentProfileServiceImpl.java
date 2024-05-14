package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.EnglishScoreRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StudentProfileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.*;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.EnglishScoreMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.StudentProfileMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.CustomerRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.EnglishScoreRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.FileUploadRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.StudentProfileRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;
    private final EnglishScoreRepository englishScoreRepository;

    private final CustomerRepository customerRepository;
    private final FileUploadRepository fileUploadRepository;

    @Autowired
    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository, EnglishScoreRepository englishScoreRepository, CustomerRepository customerRepository, FileUploadRepository fileUploadRepository) {
        this.studentProfileRepository = studentProfileRepository;
        this.englishScoreRepository = englishScoreRepository;
        this.customerRepository = customerRepository;
        this.fileUploadRepository = fileUploadRepository;
    }

    @Override
    public StudentProfileDto CreateStudentProfile(StudentProfileCreateRequest request) {

        StudentProfile studentProfile = new StudentProfile();
        UploadFile fileUpload = new UploadFile();
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new NullPointerException("Customer not found - " + request.getCustomerId()));
        //studentProfile.setStudentProfileId(0);
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
        studentProfile.setEnglishLevel(request.getEnglishLevel());
        studentProfile.setGrade(request.getGrade());

        StudentProfile result= studentProfileRepository.save(studentProfile);

        if (!(request.getFileString() == null)) {
            for (String file : request.getFileString()) {
                //fileUpload.setUploadFileId(0);
                fileUpload.setStudentProfile(studentProfile);
                fileUpload.setFileAttach(file);
                fileUploadRepository.save(fileUpload);
            }
        }
        if (request.getEnglishScoreRequest()!=null){
            EnglishScore englishScore= EnglishScoreMapper.INSTANCE.toEntity(request.getEnglishScoreRequest());
            englishScore.setStudentProfile(studentProfile);
            englishScore.setCreateDate(new Date(System.currentTimeMillis()));
            englishScoreRepository.save(englishScore);
        }
        return StudentProfileMapper.INSTANCE.toDto(result);
    }

    @Override
    public StudentProfileDto UpdateStudentProfile(Integer studentProfileId, StudentProfileUpdateRequest request) {
        StudentProfile studentProfile = studentProfileRepository.findById(studentProfileId)
                .orElseThrow(() -> new NullPointerException("Account not found - " + studentProfileId));

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
        studentProfile.setImg(request.getImg());
        studentProfile.setEnglishLevel(request.getEnglishLevel());
        studentProfile.setGrade(request.getGrade());

        studentProfile.setCreateDate(new Date(System.currentTimeMillis()));
        StudentProfile result=studentProfileRepository.save(studentProfile);
        return StudentProfileMapper.INSTANCE.toDto(result);
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

    @Override
    public List<StudentProfileDto> getAll() {
        List<StudentProfile> studentProfiles = studentProfileRepository.findAll();
        return studentProfiles.stream()
                .map(StudentProfileMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
