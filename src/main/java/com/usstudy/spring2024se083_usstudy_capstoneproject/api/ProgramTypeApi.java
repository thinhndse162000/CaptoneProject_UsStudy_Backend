package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/program-types")
@RequiredArgsConstructor
@Tag(name = "Program-Type-API")
public class ProgramTypeApi {
    private final IProgramTypeService programTypeService;

    @Operation(summary = "Get a list of ProgramType", description = "Returns a list ProgramType")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(programTypeService.getAllProgramType());
    }
    @Operation(summary = "Get a ProgramType by id", description = "Return a ProgramType")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(programTypeService.getProgramTypeById(id));
    }
}
