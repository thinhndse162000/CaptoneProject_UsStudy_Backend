package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.DocumentTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/document-types")
@RequiredArgsConstructor
@Tag(name = "Document-Type-API")
public class DocumentTypeApi {
    private final DocumentTypeService documentTypeService;
    @Operation(summary = "Get a list of Document Types", description = "Return a list of Document Types")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(documentTypeService.getAll());
    }
}
