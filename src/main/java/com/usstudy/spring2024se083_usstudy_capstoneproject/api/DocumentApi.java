package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.DocumentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.MajorRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.DocumentDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.MajorDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/documents")
@RequiredArgsConstructor
@Tag(name = "Document-API")
public class DocumentApi {
    private final DocumentService documentService;

    @Operation(summary = "Get a list of Documents", description = "Return a list of Documents")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(documentService.getAll());
    }

    @Operation(summary = "Get a Document by id", description = "Return a Document")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(documentService.getById(id));
    }

    @Operation(summary = "Create New Document", description = "Return a new Document")
    @PostMapping("")
    public ResponseEntity<?> postDocument(@RequestBody DocumentRequest documentRequest) {
        try {
            DocumentDto result = documentService.saveDocument(documentRequest,null);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @Operation(summary = "Update a Document", description = "Update a Document")
    @PutMapping("/{id}")
    public ResponseEntity<?> putDocument(@PathVariable Integer id,
                                      @RequestBody DocumentRequest documentRequest) {
        DocumentDto result = documentService.saveDocument(documentRequest,id);
        return ResponseEntity.ok(result);
    }
}
