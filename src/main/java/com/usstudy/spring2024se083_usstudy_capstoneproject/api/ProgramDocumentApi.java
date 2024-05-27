package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramDocumentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramDocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/program-documents")
@RequiredArgsConstructor
@Tag(name = "Program-Document-API")
public class ProgramDocumentApi {
    private final ProgramDocumentService programDocumentService;

    @Operation(summary = "Get a list of Program Documents", description = "Return a list of Program Documents")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(programDocumentService.getAll());
    }

    @Operation(summary = "Get a Program Document by id", description = "Return a Program Document")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(programDocumentService.getById(id));
    }
    @Operation(summary = "Get a list of Program Document by Program id", description = "Return a list of Program Document")
    @GetMapping("/program/{id}")
    public ResponseEntity<?> getByProgramId(@PathVariable Integer id) {
        return ResponseEntity.ok(programDocumentService.getByProgramId(id));
    }
    @Operation(summary = "Create a list of Program Documents", description = "Return a list of Program Documents")
    @PostMapping("")
    public ResponseEntity<?> postListProgramDocument(@RequestBody List<ProgramDocumentRequest> programDocumentRequests) {
        return ResponseEntity.ok(programDocumentService.saveListProgramDocument(programDocumentRequests));
    }
}
