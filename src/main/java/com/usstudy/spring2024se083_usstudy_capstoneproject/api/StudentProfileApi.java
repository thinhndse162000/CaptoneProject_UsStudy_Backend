package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class StudentProfileApi {

    private final StudentProfileService studentProfileService;

    @Autowired
    public StudentProfileApi(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudentProfile(@RequestBody StudentProfileCreateRequest studentProfileCreateRequest) {
        studentProfileService.CreateStudentProfile(studentProfileCreateRequest);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getByCustomerId/{id}")
    public ResponseEntity<Iterable<StudentProfile>> getAllStudentProfile(@PathVariable Integer id) {
        return ResponseEntity.ok(studentProfileService.getAllByCustomerId(id));
    }

    @PutMapping("udpate/{id}")
    public ResponseEntity<?> updateStudentProfile(@PathVariable Integer id, @RequestBody StudentProfileUpdateRequest request) {
        studentProfileService.UpdateStudentProfile(id, request);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
