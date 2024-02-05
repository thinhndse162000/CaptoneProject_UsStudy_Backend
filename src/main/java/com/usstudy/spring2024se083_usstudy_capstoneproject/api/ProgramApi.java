package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Program;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.University;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/programs")
@RequiredArgsConstructor
@Tag(name = "Program-API")
public class ProgramApi {
    private final IProgramService programService;
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false) Integer programId)
    {
        if (programId!=null)
        {
            return ResponseEntity.ok(programService.getProgramById(programId));
        }
        else {
            List<Program> result=programService.getAllProgram();
            return ResponseEntity.ok(result);
        }
    }
}
