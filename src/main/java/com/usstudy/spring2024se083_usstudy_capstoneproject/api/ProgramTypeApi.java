package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.IProgramTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/program-types")
@RequiredArgsConstructor
@Tag(name = "ProgramType-API")
public class ProgramTypeApi {
    private final IProgramTypeService programTypeService;
    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(required = false)Integer programTypeId)
    {
        if (programTypeId!=null){
            return ResponseEntity.ok(programTypeService.getProgramTypeById(programTypeId));
        }else {
            return ResponseEntity.ok(programTypeService.getAllProgramType());
        }
    }
}
