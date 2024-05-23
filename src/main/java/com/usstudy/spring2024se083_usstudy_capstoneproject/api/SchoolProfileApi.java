package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.SchoolProfileRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.SchoolProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/school-profiles")
@RequiredArgsConstructor
@Tag(name = "School-Profile-API")
public class SchoolProfileApi {
    private final SchoolProfileService schoolProfileService;
    @Operation(summary = "Get a list of School Profile", description = "Return a list of School Profile")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(schoolProfileService.getAll());
    }
    @Operation(summary = "Get a School Profile by id", description = "Return a School Profile")
    @GetMapping("/{id}")
    public ResponseEntity<?> getBySchoolProfileId(@PathVariable Integer id) {
        return ResponseEntity.ok(schoolProfileService.getById(id));
    }
    @Operation(summary = "Get a list School Profile by Student Profile id", description = "Return a list of School Profile")
    @GetMapping("/student-profile/{id}")
    public ResponseEntity<?> getByStudentProfileId(@PathVariable Integer id) {
        return ResponseEntity.ok(schoolProfileService.getByStudentProfileId(id));
    }
    @Operation(summary = "Create a School Profile", description = "Return a School Profile")
    @PostMapping("")
    public ResponseEntity<?> postSchoolProfile(@RequestBody SchoolProfileRequest schoolProfileRequest){
        return ResponseEntity.ok(schoolProfileService.saveSchoolProfile(schoolProfileRequest));
    }
}
