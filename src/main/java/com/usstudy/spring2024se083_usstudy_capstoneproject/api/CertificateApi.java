package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.CertificateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.CertificateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/certificates")
@RequiredArgsConstructor
@Tag(name = "Certificate-API")
public class CertificateApi {
    private final CertificateService certificateService;

    @Operation(summary = "Get a list of Certificate", description = "Return a list of Certificate")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(certificateService.getAll());
    }
    @Operation(summary = "Get a Certificate by id", description = "Return a Certificate")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(certificateService.getById(id));
    }
    @Operation(summary = "Update a Certificate by id", description = "Return updated Certificate")
    @PutMapping("/{id}")
    public ResponseEntity<?> putCertificate(@PathVariable Integer id,
                                            @RequestBody CertificateRequest certificateRequest) {
        return ResponseEntity.ok(certificateService.saveCertificate(certificateRequest,id));
    }
    @Operation(summary = "Create a Certificate by id", description = "Return new Certificate")
    @PostMapping("")
    public ResponseEntity<?> postCertificate(@RequestBody CertificateRequest certificateRequest) {
        return ResponseEntity.ok(certificateService.saveCertificate(certificateRequest,null));
    }
}