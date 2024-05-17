package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.CertificateTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/certificate-types")
@RequiredArgsConstructor
@Tag(name = "Certificate-Type-API")
public class CertificateTypeApi {
    private final CertificateTypeService certificateTypeService;
    @Operation(summary = "Get a list of Certificate Types", description = "Return a list of Certificate Types")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(certificateTypeService.getAll());
    }
}
