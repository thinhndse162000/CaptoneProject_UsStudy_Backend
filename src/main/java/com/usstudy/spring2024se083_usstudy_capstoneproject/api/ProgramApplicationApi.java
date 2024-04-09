package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramApplicationDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/program-applications")
@RequiredArgsConstructor
@Tag(name = "ProgramApplication-API")
public class ProgramApplicationApi {
    private final ProgramApplicationService programApplicationService;
    @Operation(summary = "Get a Program Application by program application id", description = "Return a program application")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByProgramApplicationId(@PathVariable Integer id) {
        return ResponseEntity.ok(programApplicationService.getById(id));
    }
    @Operation(summary = "Get a list of Program Application", description = "Return a list of program application")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(programApplicationService.getAllFilter());
    }
    @Operation(summary = "Get a Program Application by student profile id", description = "Return a program application")
    @GetMapping("/student-profile/{id}")
    public ResponseEntity<?> getByStudentProfileId(@PathVariable Integer id) {
        return ResponseEntity.ok(programApplicationService.getByStudentProfileId(id));
    }
    @Operation(summary = "Create a Program Application", description = "Return a program application if success")
    @PostMapping("")
    public ResponseEntity<?> postProgramApplication(@RequestBody ProgramApplicationDto programApplicationDto) {
        return ResponseEntity.ok(programApplicationService.saveProgramApplication(programApplicationDto));
    }
}
