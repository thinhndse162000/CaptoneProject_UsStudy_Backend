package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.StudentProfile;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.StudentProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v3/profile")
@Tag(name = "Student-Profile-API")
public class StudentProfileApi {

    private final StudentProfileService studentProfileService;

    @Autowired
    public StudentProfileApi(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @Operation(summary = "Create Student Profile ", description = "Customer Create Student Profile")
    @PostMapping("/")
    public ResponseEntity<?> createStudentProfile(@RequestBody StudentProfileCreateRequest studentProfileCreateRequest) {
        studentProfileService.CreateStudentProfile(studentProfileCreateRequest);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get Student Profile by Id ", description = "Returns student profile by id")
    @GetMapping("{id}")
    public ResponseEntity<Optional<StudentProfile>> getStudentProfileById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentProfileService.getById(id));
    }

    @Operation(summary = "Get all Student Profile by Customer Id", description = "Returns all Student profile by Customer id")
    @GetMapping("/customer/{id}")
    public ResponseEntity<Iterable<StudentProfile>> getAllStudentProfileByCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(studentProfileService.getAllByCustomerId(id));
    }

    @Operation(summary = "Update Student Profile ", description = "Update Student Profile ")
    @PutMapping("{id}")
    public ResponseEntity<?> updateStudentProfile(@PathVariable Integer id, @RequestBody StudentProfileUpdateRequest request) {
        studentProfileService.UpdateStudentProfile(id, request);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
