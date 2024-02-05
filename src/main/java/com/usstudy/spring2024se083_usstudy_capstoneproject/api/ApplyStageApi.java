package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageSubmitRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ApplyStageUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ApplyStageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apply")
public class ApplyStageApi {
    private final ApplyStageService service;

    public ApplyStageApi(ApplyStageService service) {
        this.service = service;
    }

    @PostMapping("/submit")
    public void submitApplyStage(@RequestBody ApplyStageSubmitRequest request){
        service.submitApplyStage(request);
    }

    @PutMapping("/update/{id}")
    public void updateApplyStage(@PathVariable Integer id, ApplyStageUpdateRequest request){
        service.updateApplyStage(id, request);
    }


}
