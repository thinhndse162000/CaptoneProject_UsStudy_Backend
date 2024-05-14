package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.StudentProfileUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StudentProfileDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.StudentProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ResponseEntity.ok(studentProfileService.CreateStudentProfile(studentProfileCreateRequest));
    }

    @Operation(summary = "Get Student Profile by Id ", description = "Returns student profile by id")
    @GetMapping("{id}")
    public ResponseEntity<StudentProfileDto> getStudentProfileById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentProfileService.getById(id).orElseThrow());
    }

    @Operation(summary = "Get all Student Profile by Customer Id", description = "Returns all Student profile by Customer id")
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getAllStudentProfileByCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(studentProfileService.getAllByCustomerId(id));
    }

    @Operation(summary = "Update Student Profile ", description = "Update Student Profile ")
    @PutMapping("{id}")
    public ResponseEntity<?> updateStudentProfile(@PathVariable Integer id, @RequestBody StudentProfileUpdateRequest request) {
        return ResponseEntity.ok(studentProfileService.UpdateStudentProfile(id, request));
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentProfileDto>> getAllStudentProfile() {
        return ResponseEntity.ok(studentProfileService.getAll());
    }
}
