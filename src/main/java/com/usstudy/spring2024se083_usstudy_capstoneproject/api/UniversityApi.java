package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IUniversityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/universities")
@RequiredArgsConstructor
@Tag(name = "University-API")
public class UniversityApi {
    private final IUniversityService universityService;
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Integer universityId)
    {
        if (universityId!=null)
        {
            return ResponseEntity.ok(universityService.getUniversityById(universityId));
        }
        else {
            List<University> result=universityService.getAllUniversity();
            return ResponseEntity.ok(result);
        }
    }
}
