package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IUniversityTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/university-types")
@RequiredArgsConstructor
@Tag(name = "UniversityType-API")
public class UniversityTypeApi {
    private final IUniversityTypeService universityTypeService;
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false)Integer universityTypeId)
    {
        if (universityTypeId!=null){
            return ResponseEntity.ok(universityTypeService.getUniversityTypeById(universityTypeId));
        }else {
            return ResponseEntity.ok(universityTypeService.getAllUniversityType());
        }
    }
}
