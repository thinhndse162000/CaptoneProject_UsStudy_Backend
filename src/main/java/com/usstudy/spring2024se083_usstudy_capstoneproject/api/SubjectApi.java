package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.SubjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/subjects")
@RequiredArgsConstructor
@Tag(name = "Subject-API")
public class SubjectApi {
    private final SubjectService subjectService;
    @Operation(summary = "Get a list of Subjects", description = "Return a list of Subjects")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(subjectService.getAll());
    }
    @Operation(summary = "Get a Subject by id", description = "Return a Subject")
    @GetMapping("/{id}")
    public ResponseEntity<?> getBySubjectId(@PathVariable Integer id) {
        return ResponseEntity.ok(subjectService.getById(id));
    }
}
