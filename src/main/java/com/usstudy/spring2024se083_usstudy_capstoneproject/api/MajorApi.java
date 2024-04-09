package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.MajorDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IMajorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/majors")
@RequiredArgsConstructor
@Tag(name = "Major-API")
public class MajorApi {

    private final IMajorService majorService;


    @Operation(summary = "Get a list of Majors", description = "Return a list of Majors")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(majorService.getAllMajor());
    }
    @Operation(summary = "Get a Major by major id", description = "Return a Major")
    @GetMapping("/{id}")
    public ResponseEntity<?> getByMajorId(@PathVariable Integer id) {
        return ResponseEntity.ok(majorService.findById(id));
    }

    @Operation(summary = "Create New Major", description = "Create a new Major")
    @PostMapping("")
    public ResponseEntity<?> postMajor(@RequestBody MajorDto majorDto) {
        try {
            MajorDto result = majorService.saveMajor(majorDto);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @Operation(summary = "Update a Major", description = "Update a Major")
    @PutMapping("/{id}")
    public ResponseEntity<?> putMajor(@PathVariable Integer id,
                                      @RequestBody MajorDto majorDto) {
        try {
            majorDto.setMajorId(id);
            if (!majorService.findById(id).isEmpty()) {
                MajorDto result = majorService.saveMajor(majorDto);
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.badRequest().body("No major with id " + majorDto.getMajorId() + " found!");
            }
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
