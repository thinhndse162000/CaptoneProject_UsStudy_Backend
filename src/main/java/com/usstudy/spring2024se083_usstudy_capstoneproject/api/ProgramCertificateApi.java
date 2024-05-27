package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProgramCertificateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ProgramCertificateDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProgramCertificateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/program-certificates")
@RequiredArgsConstructor
@Tag(name = "Program-Certificate-API")
public class ProgramCertificateApi {

    @Autowired
    private final ProgramCertificateService service;

    @PostMapping("/program-certificate")
    public ResponseEntity<ProgramCertificateDto> postProgramCertificate(ProgramCertificateRequest request) {
        return ResponseEntity.ok(service.createProgramCertificate(request));
    }
    @PostMapping("")
    @Operation(summary = "Create a list of Program Certificate", description = "Return a list of Program Certificate")
    public ResponseEntity<?> postListProgramCertificate(List<ProgramCertificateRequest> request) {
        return ResponseEntity.ok(service.saveListProgramCertificate(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramCertificateDto> putProgramCertificate(ProgramCertificateRequest request, Integer id) {
        return ResponseEntity.ok(service.updateProgramCertificate(request, id));
    }

    @GetMapping()
    public ResponseEntity<List<ProgramCertificateDto>> getAllProgramCertificate() {
        return ResponseEntity.ok(service.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProgramCertificateDto> getProgramCertificateByid(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping("/program/{id}")
    @Operation(summary = "Get a list of Program Certificate by Program id", description = "Return a list of Program Certificate")
    public ResponseEntity<?> getProgramCertificateByProgramId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getByProgramId(id));
    }
}
