package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class StudentProfileApi {

    private final StudentProfileService studentProfileService;
    @Autowired
    public StudentProfileApi(StudentProfileService studentProfileService){
        this.studentProfileService = studentProfileService;
    }
    @PostMapping("/create")
    public void createStudentProfile(@RequestBody StudentProfileCreateRequest studentProfileCreateRequest){
        studentProfileService.CreateStudentProfile(studentProfileCreateRequest);
    }
    @GetMapping("/getByCustomerId/{id}")
    public Iterable<StudentProfile> getAllStudentProfile(@PathVariable Integer id){
        return studentProfileService.getAllByCustomerId(id);
    }

    @PutMapping("udpate/{id}")
    public void updateStudentProfile(@PathVariable Integer id, @RequestBody StudentProfileUpdateRequest request){
        studentProfileService.UpdateStudentProfile(id, request);
    }
}
