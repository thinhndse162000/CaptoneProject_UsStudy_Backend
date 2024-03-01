package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/program-types")
@RequiredArgsConstructor
@Tag(name = "ProgramType-API")
public class ProgramTypeApi {
    private final IProgramTypeService programTypeService;
    @GetMapping("")
<<<<<<< Updated upstream
    public ResponseEntity<?> getAll(@RequestParam(required = false)Integer programTypeId)
    {
        if (programTypeId!=null){
            return ResponseEntity.ok(programTypeService.getProgramTypeById(programTypeId));
        }else {
            return ResponseEntity.ok(programTypeService.getAllProgramType());
        }
=======
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(programTypeService.getAllProgramType());
    }
    @Operation(summary = "Get a ProgramType by id", description = "Return a ProgramType")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(programTypeService.getProgramTypeById(id));
>>>>>>> Stashed changes
    }
}
