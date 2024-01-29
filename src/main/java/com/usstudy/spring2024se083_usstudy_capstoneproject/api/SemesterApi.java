package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.service.interfaces.ISemesterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/semesters")
@RequiredArgsConstructor
@Tag(name = "Semester-API")
public class SemesterApi {
    private final ISemesterService semesterService;
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false)Integer semesterId)
    {
        if (semesterId!=null){
            return ResponseEntity.ok(semesterService.findSemesterById(semesterId));
        }else {
            return ResponseEntity.ok(semesterService.getAllSemester());
        }
    }
}
