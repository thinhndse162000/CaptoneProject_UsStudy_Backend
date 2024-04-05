package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.UniversityDto;
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
//@SecurityRequirement(name = "Authorization")
public class UniversityApi {
    private final IUniversityService universityService;

    //@Secured("ROLE_CUSTOMER")
    @Operation(summary = "Get a list Universities", description = "Return a list Universities")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<UniversityDto> result = universityService.getAllUniversity();
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Get an University by university id", description = "Return a University")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByUniversityId(@PathVariable Integer id) {
        return ResponseEntity.ok(universityService.getUniversityById(id));
    }

    @Operation(summary = "Create University ", description = "Create University ")
    @PostMapping("")
    public ResponseEntity<?> postUniversity(@RequestBody UniversityDto universityDto) {
        try {
            UniversityDto result = universityService.saveUniversity(universityDto);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @GetMapping("/type")
    public ResponseEntity<?> getUniversityByType(@RequestParam Integer typeId) {
        return ResponseEntity.ok(universityService.getUniversityByTypeId(typeId));
    }

    @GetMapping("/state")
    public ResponseEntity<?> getUniversityByState(@RequestParam Integer stateId) {
        return ResponseEntity.ok(universityService.getUniversityByStateId(stateId));
    }

    @Operation(summary = "Update University ", description = "Update University ")
    @PutMapping("/{id}")
    public ResponseEntity<?> putUniversity(@PathVariable Integer id,
                                           @RequestBody UniversityDto universityDto) {
        try {
            universityDto.setUniversityId(id);
            if (!universityService.getUniversityById(id).isEmpty()) {
                UniversityDto result = universityService.saveUniversity(universityDto);
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.badRequest().body("No University with id " + universityDto.getUniversityId() + " found!");
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
