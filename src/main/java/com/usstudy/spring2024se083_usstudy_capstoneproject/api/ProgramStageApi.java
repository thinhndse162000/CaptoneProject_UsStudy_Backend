package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramStageRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramStageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/program-stages")
@RequiredArgsConstructor
@Tag(name = "Program-Stage-API")
public class ProgramStageApi {
    private final ProgramStageService programStageService;

    @Operation(summary = "Get a Program stage by program stage id", description = "Return a program stage")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByProgramId(@PathVariable Integer id) {
        return ResponseEntity.ok(programStageService.findByProgramStageId(id));
    }
    @Operation(summary = "Get a list of Program stage filter by program id", description = "Return a list of program stage")
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Integer programId,
                                    @RequestParam(required = false) Integer stageNo) {
        return ResponseEntity.ok(programStageService.findByProgramId(programId,stageNo));
    }
    @Operation(summary = "Create a new program stage", description = "Return new program stage if success")
    @PostMapping("/program-stage")
    public ResponseEntity<?> postProgramStage(@RequestBody ProgramStageRequest programStageRequest) {
        return ResponseEntity.ok(programStageService.saveProgramStage(programStageRequest));
    }
    @Operation(summary = "Create a list of new program stage", description = "Return new list program stage if success")
    @PostMapping("")
    public ResponseEntity<?> postProgramStageList(@RequestBody List<ProgramStageRequest> programStageRequest) {
        return ResponseEntity.ok(programStageService.saveListProgram(programStageRequest));
    }
}
