package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ProfileScoreRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ProfileScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Operation(summary = "Get a Profile Score by id", description = "Return a Profile Score")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByProfileScoreId(@PathVariable Integer id) {
        return ResponseEntity.ok(profileScoreService.getById(id));
    }
    @Operation(summary = "Create a Profile Score", description = "Return a Profile Score")
    @PostMapping("")
    public ResponseEntity<?> postProfileScore(@RequestBody ProfileScoreRequest profileScoreRequest){
        return ResponseEntity.ok(profileScoreService.saveProfileScore(profileScoreRequest,null));
    }
    @Operation(summary = "Create a Profile Score", description = "Return a Profile Score")
    @PostMapping("/list-profile-score")
    public ResponseEntity<?> postListProfileScore(@RequestBody List<ProfileScoreRequest> profileScoreRequest){
        try {
            profileScoreService.saveListProfileScore(profileScoreRequest);
            return ResponseEntity.ok(HttpStatus.NO_CONTENT);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @Operation(summary = "Update a Profile Score", description = "Return a Profile Score")
    @PutMapping("/{id}")
    public ResponseEntity<?> putProfileScore(@RequestBody ProfileScoreRequest profileScoreRequest,
                                             @PathVariable Integer id){
        return ResponseEntity.ok(profileScoreService.saveProfileScore(profileScoreRequest,id));
    }
}
