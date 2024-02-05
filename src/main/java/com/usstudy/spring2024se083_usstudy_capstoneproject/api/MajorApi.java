package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Major;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/majors")
@RequiredArgsConstructor
@Tag(name = "Major-API")
public class MajorApi {

    private final IMajorService majorService;
    @GetMapping("")
    public ResponseEntity<?> getAll()
    {
        List<Major> result=majorService.getAllMajor();
        return ResponseEntity.ok(result);
    }
}
