package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v3/programs")
@RequiredArgsConstructor
@Tag(name = "Program-API")
public class ProgramApi {
    private final IProgramService programService;
  
    @Operation(summary = "Get a list of Programs", description = "Return a list of programs base on some condition")
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Integer universityId,
                                    @RequestParam(required = false) Integer majorId,
                                    @RequestParam(required = false) String programName) {
        if (programName!=null){
            return ResponseEntity.ok(programService.getProgramsByProgramName(programName));
        }
        if (universityId != null && majorId!=null) {
            return ResponseEntity.ok(programService.getProgramsByUniversityIdAndMajorId(universityId,majorId));
        } else {
            if (universityId!=null){
                return ResponseEntity.ok(programService.getProgramsByUniversityId(universityId));
            }
            if (majorId!=null){
                return ResponseEntity.ok(programService.getProgramsByMajorId(majorId));
            }
            Iterable<Program> result = programService.getAllProgram();
            return ResponseEntity.ok(result);
        }
    }
    @Operation(summary = "Get a Program by program id", description = "Return a program")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByProgramId(@PathVariable Integer id){
        return ResponseEntity.ok(programService.getProgramById(id));
    }

    @Operation(summary = "Create new Program", description = "Create new Program")
    @PostMapping("")
    public ResponseEntity<?> postProgram(@RequestBody Program program,
                                         @RequestParam(required = false, defaultValue = "false") Boolean useServerTime) {
        try {
            if (useServerTime == true) {
                program.setCreateDate(LocalDate.now());
            }
            Program result = programService.saveProgram(program);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @Operation(summary = "Update a Program", description = "Update a program ")
    @PutMapping("")
    public ResponseEntity<?> putProgram(@RequestBody Program program,
                                        @RequestParam(required = false, defaultValue = "false") Boolean useServerTime) {
        try {
            if (program.getProgramId() != null && !programService.getProgramById(program.getProgramId()).isEmpty()) {
                if (useServerTime == true) {
                    program.setModifiedDate(LocalDate.now());
                }
                Program result = programService.saveProgram(program);
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.badRequest().body("No major with id " + program.getProgramId() + " found!");
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
