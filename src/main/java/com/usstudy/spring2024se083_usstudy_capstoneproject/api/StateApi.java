package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.State;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IStateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v3/states")
@RequiredArgsConstructor
@Tag(name = "State-API")
public class StateApi {
    private final IStateService stateService;

    @Operation(summary = "Get all State", description = "Returns all State")
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Integer stateId) {
        if (stateId != null) {
            return ResponseEntity.ok(stateService.getStateById(stateId));
        } else {
            List<State> result = stateService.getAllState();
            return ResponseEntity.ok(result);
        }
    }
}
