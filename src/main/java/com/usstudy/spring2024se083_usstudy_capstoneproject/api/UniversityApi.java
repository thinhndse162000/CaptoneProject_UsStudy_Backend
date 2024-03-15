package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IUniversityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/universities")
@RequiredArgsConstructor
@Tag(name = "University-API")
@SecurityRequirement(name = "Authorization")
public class UniversityApi {
    private final IUniversityService universityService;

    @Secured("ROLE_CUSTOMER")
    @Operation(summary = "Get all Universities", description = "Return all Universities")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<University> result = universityService.getAllUniversity();
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Get an University by university id", description = "Return a University")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByUniversityId(@PathVariable Integer id) {
        return ResponseEntity.ok(universityService.getUniversityById(id));
    }

    @Operation(summary = "Create University ", description = "Create University ")
    @PostMapping("")
    public ResponseEntity<?> postUniversity(@RequestBody University university) {
        try {
            University result = universityService.saveUniversity(university);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @Operation(summary = "Update University ", description = "Update University ")
    @PutMapping("")
    public ResponseEntity<?> putUniversity(@RequestBody University university) {
        try {
            if (university.getUniversityId() != null && !universityService.getUniversityById(university.getUniversityId()).isEmpty()) {
                University result = universityService.saveUniversity(university);
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.badRequest().body("No University with id " + university.getUniversityId() + " found!");
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
