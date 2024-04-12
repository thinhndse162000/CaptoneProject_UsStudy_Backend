package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegistrationFormCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegistrationFormUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.RegistrationForm;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.RegistrationFormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/registration-forms")
@Tag(name = "Registration-Form-API")
public class RegistrationFormApi {
    private final RegistrationFormService service;

    @Autowired
    public RegistrationFormApi(RegistrationFormService service) {
        this.service = service;
    }

    @Operation(summary = "Submit RegistrationForm", description = "Create new Registration Form")
    @PostMapping("")
    public void submitRegistrationForm(@RequestBody RegistrationFormCreateRequest request) {
        service.CreateRegistrationForm(request);
    }

    @Operation(summary = "Get a list of Registration Forms by Customer id",
            description = "Returns a list of Registration Forms by Customer id")
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getRegistrationFormByCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getRegistrationFormByCustomer(id));
    }

    @Operation(summary = "Get a list of Registration Forms filter by Consultant Id",
            description = "Return a list of Registration Forms filter by Consultant id")
    @GetMapping("/consultant/{id}")
    public ResponseEntity<?> getRegistrationFormByConsultant(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getRegistrationFormByConsultant(id));
    }

    @Operation(summary = "Get a list of Registration Forms ", description = "Returns a list of Registration Forms")
    @GetMapping("")
    public ResponseEntity<?> getAllRegistrationForm() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Update Registration Form", description = "Update Registration Form")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRegistrationForm(@PathVariable Integer id, @RequestBody RegistrationFormUpdateRequest request) {
        service.updateRegistrationForm(id, request);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
