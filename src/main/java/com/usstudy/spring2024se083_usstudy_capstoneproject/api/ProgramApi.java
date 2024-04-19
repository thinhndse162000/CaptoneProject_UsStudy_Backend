package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/programs")
@RequiredArgsConstructor
@Tag(name = "Program-API")
//@SecurityRequirement(name = "Authorization")
public class ProgramApi {
    private final IProgramService programService;


    //@Secured({"ROLE_CONSULTANT","ROLE_CUSTOMER"})
    @Operation(summary = "Get a list of Programs", description = "Return a list of programs")
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Integer universityId,
                                    @RequestParam(required = false) Integer majorId,
                                    @RequestParam(required = false) String programName,
                                    @RequestParam(required = false) Integer programTypeId,
                                    @RequestParam(required = false) Integer semesterId) {
        if (programName != null) {
            return ResponseEntity.ok(programService.getProgramsByProgramName(programName));
        }
        if (universityId != null && majorId != null) {
            return ResponseEntity.ok(programService.getProgramsByUniversityIdAndMajorId(universityId, majorId));
        } else {
            if (universityId != null) {
                return ResponseEntity.ok(programService.getProgramsByUniversityId(universityId));
            }
            if (majorId != null) {
                return ResponseEntity.ok(programService.getProgramsByMajorId(majorId));
            }
            if (programTypeId != null) {
                return ResponseEntity.ok(programService.getProgramsByProgramTypeId(programTypeId));
            }
            if (semesterId != null) {
                return ResponseEntity.ok(programService.getProgramsBySemesterId(semesterId));
            }
            Iterable<ProgramDto> result = programService.getAllProgram();
            return ResponseEntity.ok(result);
        }
    }

    @Operation(summary = "Get a Program by program id", description = "Return a program")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByProgramId(@PathVariable Integer id) {
        return ResponseEntity.ok(programService.getProgramById(id));
    }

    @Operation(summary = "Create new Program", description = "Create new Program")
    @PostMapping("")
    public ResponseEntity<?> postProgram(@RequestBody ProgramRequest programDto) {
        try {
            ProgramDto result = programService.saveProgram(programDto);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PostMapping("/filter")
    public ResponseEntity<List<ProgramDto>> filterProgram(@RequestBody ProgramFilterRequest request) {
        return ResponseEntity.ok(programService.getProgrambyRequest(request));
    }

    @Operation(summary = "Update a Program", description = "Update a program ")
    @PutMapping("/{id}")
    public ResponseEntity<?> putProgram(@PathVariable Integer id,
                                        @RequestBody ProgramUpdateRequest request) {
//        try {
//            programDto.setProgramId(id);
//            if (programDto.getProgramId() != null && !programService.getProgramById(programDto.getProgramId()).isEmpty()) {
//                ProgramDto result = programService.saveProgram(programDto);
//                return ResponseEntity.ok(result);
//            } else {
//                return ResponseEntity.badRequest().body("No program with id " + programDto.getProgramId() + " found!");
//            }
//        } catch (Exception ex) {
//            return ResponseEntity.internalServerError().body(ex.getMessage());
//        }
        programService.updateProgram(request, id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/university/{universityId}")
    public ResponseEntity<List<ProgramDto>> listResponseEntity(@PathVariable Integer universityId) {
        return ResponseEntity.ok(programService.getProgramList(universityId));
    }
}
