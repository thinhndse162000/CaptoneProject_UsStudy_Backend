package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageSubmitRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.ApplyStage;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ApplyStageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v3/apply-stage")
@Tag(name = "Apply-Stage-API")
public class ApplyStageApi {
    private final ApplyStageService service;

    public ApplyStageApi(ApplyStageService service) {
        this.service = service;
    }

    @Operation(summary = "Create ApplyStage", description = "Customer Submit Student Profile for a Program")
    @PostMapping("/")
    public ResponseEntity<?> submitApplyStage(@RequestBody ApplyStageSubmitRequest request) {
        service.submitApplyStage(request);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Update Apply Stage", description = "Apply Stage Update Program Stages")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateApplyStage(@PathVariable Integer id, ApplyStageUpdateRequest request) {
        service.updateApplyStage(id, request);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }


    @Operation(summary = "Get All Apply Stage", description = "Return Apply Stage ")
    @GetMapping("/")
    public ResponseEntity<Iterable<ApplyStage>> getAllApplyStage() {
        return ResponseEntity.ok(service.getAllApplyStage());
    }

    @Operation(summary = "Get a Apply Stage by id", description = "Returns a Apply Stage by id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ApplyStage>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
