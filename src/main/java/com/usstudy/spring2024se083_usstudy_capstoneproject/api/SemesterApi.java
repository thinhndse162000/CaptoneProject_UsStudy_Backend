package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ISemesterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/semesters")
@RequiredArgsConstructor
@Tag(name = "Semester-API")
public class SemesterApi {
    private final ISemesterService semesterService;
<<<<<<< Updated upstream
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false)Integer semesterId)
    {
        if (semesterId!=null){
            return ResponseEntity.ok(semesterService.findSemesterById(semesterId));
        }else {
            return ResponseEntity.ok(semesterService.getAllSemester());
        }
=======

    @Operation(summary = "Get all semester", description = "Return all Semesters")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(semesterService.getAllSemester());
    }
    @Operation(summary = "Get a semester by id", description = "Return a Semester")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(semesterService.findSemesterById(id));
>>>>>>> Stashed changes
    }
}
