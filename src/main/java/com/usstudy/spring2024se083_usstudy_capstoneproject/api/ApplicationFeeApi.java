package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ApplicationFeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/application-fees")
@RequiredArgsConstructor
@Tag(name = "Application-Fee-API")
public class ApplicationFeeApi {
    private final ApplicationFeeService applicationFeeService;

    @Operation(summary = "Get an Application Fee by id", description = "Returns a Application Fee by id")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(applicationFeeService.findById(id));
    }
    @Operation(summary = "Get a list of Application Fees", description = "Returns a list of Application Fee")
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(applicationFeeService.getAll());
    }
}
