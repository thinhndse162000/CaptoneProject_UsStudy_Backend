package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.EnglishScoreRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.MajorRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.EnglishScoreDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.MajorDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.EnglishScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/english-score")
@RequiredArgsConstructor
@Tag(name = "English-Score-API")
public class EnglishScoreApi {
    private final EnglishScoreService englishScoreService;

    @Operation(summary = "Get a list of English Scores", description = "Return a list of English Scores")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(englishScoreService.getAll());
    }
    @Operation(summary = "Get an English Score by id", description = "Return a English Score")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(englishScoreService.getById(id));
    }

    @Operation(summary = "Create New English Score", description = "Create a new English Score")
    @PostMapping("")
    public ResponseEntity<?> postEnglishScore(@RequestBody EnglishScoreRequest englishScoreRequest) {
        try {
            EnglishScoreDto result = englishScoreService.saveEnglishScore(englishScoreRequest,null);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @Operation(summary = "Update an English Score", description = "Update an English Score")
    @PutMapping("/{id}")
    public ResponseEntity<?> putEnglishScore(@PathVariable Integer id,
                                      @RequestBody EnglishScoreRequest englishScoreRequest) {
        EnglishScoreDto result = englishScoreService.saveEnglishScore(englishScoreRequest,id);
        return ResponseEntity.ok(result);
    }
}
