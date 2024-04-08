package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramStageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/program-stages")
@RequiredArgsConstructor
@Tag(name = "ProgramStage-API")
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
}
