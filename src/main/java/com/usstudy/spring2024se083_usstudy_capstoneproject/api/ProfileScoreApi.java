package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProfileScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/profile-score")
@RequiredArgsConstructor
@Tag(name = "Profile-Score-API")
public class ProfileScoreApi {
    private final ProfileScoreService profileScoreService;
    @Operation(summary = "Get a list of Profile Score", description = "Return a list of Profile Score")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(profileScoreService.getAll());
    }
    @Operation(summary = "Get a Subject by id", description = "Return a Subject")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByProfileScoreId(@PathVariable Integer id) {
        return ResponseEntity.ok(profileScoreService.getById(id));
    }
}
