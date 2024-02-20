package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageSubmitRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ApplyStageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apply")
public class ApplyStageApi {
    private final ApplyStageService service;

    public ApplyStageApi(ApplyStageService service) {
        this.service = service;
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitApplyStage(@RequestBody ApplyStageSubmitRequest request) {
        service.submitApplyStage(request);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateApplyStage(@PathVariable Integer id, ApplyStageUpdateRequest request) {
        service.updateApplyStage(id, request);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }


}
