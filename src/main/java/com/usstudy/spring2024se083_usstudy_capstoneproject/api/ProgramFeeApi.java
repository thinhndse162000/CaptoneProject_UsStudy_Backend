package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramFeeRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramFeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/program-fees")
@RequiredArgsConstructor
@Tag(name = "Program-Fee-API")
public class ProgramFeeApi {
    private final ProgramFeeService programFeeService;
    @Operation(summary = "Get a Program Fee by id", description = "Return a program fee")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(programFeeService.findById(id));
    }
    @Operation(summary = "Get a list of Program Fees by program id", description = "Return a list of program fees")
    @GetMapping("/program/{id}")
    public ResponseEntity<?> getByProgramId(@PathVariable Integer id) {
        return ResponseEntity.ok(programFeeService.findByProgramId(id));
    }
    @Operation(summary = "Get a list of Program Fees", description = "Return a list of program fees")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(programFeeService.getAll());
    }
    @Operation(summary = "Create a Program Fee", description = "Return a program fee if success")
    @PostMapping("/program-fee")
    public ResponseEntity<?> postProgramFee(@RequestBody ProgramFeeRequest programFeeRequest) {
        return ResponseEntity.ok(programFeeService.saveProgramFee(programFeeRequest,null));
    }
    @Operation(summary = "Create a list of Program Fee", description = "Return a list of program fee if success")
    @PostMapping("")
    public ResponseEntity<?> postListProgramFee(@RequestBody List<ProgramFeeRequest> programFeeRequest) {
        return ResponseEntity.ok(programFeeService.saveListProgramFee(programFeeRequest));
    }
    @Operation(summary = "Update a Program Fee", description = "Return a program fee if success")
    @PutMapping("/{id}")
    public ResponseEntity<?> putProgramFee(@PathVariable Integer id,
                                           @RequestBody ProgramFeeRequest programFeeRequest) {
        return ResponseEntity.ok(programFeeService.saveProgramFee(programFeeRequest,id));
    }
}
