package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.SemesterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ISemesterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/semesters")
@RequiredArgsConstructor
@Tag(name = "Semester-API")
public class SemesterApi {
    private final ISemesterService semesterService;


    @Operation(summary = "Get a list of semester", description = "Return a list of Semesters")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(semesterService.getAllSemester());
    }
    @Operation(summary = "Get a semester by id", description = "Return a Semester")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(semesterService.findSemesterById(id));
    }
    @Operation(summary = "Create a semester", description = "Return a Semester")
    @PostMapping("/semester")
    public ResponseEntity<?> postSemester(@RequestBody SemesterRequest semesterRequest) {
        return ResponseEntity.ok(semesterService.saveSemester(semesterRequest));
    }
}
