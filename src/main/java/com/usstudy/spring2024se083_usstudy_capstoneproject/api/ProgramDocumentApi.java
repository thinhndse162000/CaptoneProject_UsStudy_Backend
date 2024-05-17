package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramDocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
