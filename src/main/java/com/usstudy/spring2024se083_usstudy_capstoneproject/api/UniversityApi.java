package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IUniversityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public ResponseEntity<?> postUniversity(@RequestBody University university){
        try {
            University result= universityService.saveUniversity(university);
            return  ResponseEntity.ok(result);
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
    @PutMapping("")
    public ResponseEntity<?> putUniversity(@RequestBody University university){
        try {
            if (university.getUniversityId()!=null && !universityService.getUniversityById(university.getUniversityId()).isEmpty())
            {
                University result= universityService.saveUniversity(university);
                return  ResponseEntity.ok(result);
            }
            else {
                return ResponseEntity.badRequest().body("No major with id "+university.getUniversityId()+" found!");
            }
        }
        catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
