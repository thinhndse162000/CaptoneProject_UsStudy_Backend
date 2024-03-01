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
@RequestMapping("/v3/registration-form/")
@Tag(name = "Registration-Form-API")
public class RegistrationFormApi {
    private final RegistrationFormService service;

    @Autowired
    public RegistrationFormApi(RegistrationFormService service) {
        this.service = service;
    }

    @Operation(summary = "Submit ResgistrationForm", description = "Create new Registration Form")
    @PostMapping("/")
    public void submitRegistrationForm(RegistrationFormCreateRequest request) {
        service.CreateRegistrationForm(request);
    }

    @Operation(summary = "Get all Registration Form by Customer id", description = "Returns all Registration Form by Customer id")
    @GetMapping("/customer/{id}")
    public ResponseEntity<Iterable<RegistrationForm>> getRegistrationFormByCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getRegistrationFormByCustomer(id));
    }

    @Operation(summary = "Get all Registration form by Consultant Id", description = "Returns Registration Form by Consultant id")
    @GetMapping("/consultant/{id}")
    public ResponseEntity<Iterable<RegistrationForm>> getRegistrationFormByConsultant(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getRegistrationFormByConsultant(id));
    }

    @Operation(summary = "Get all Registration Form ", description = "Returns all Registration Form")
    @GetMapping("/")
    public ResponseEntity<Iterable<RegistrationForm>> getAllRegistrationForm() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Update Registration Form", description = "Update Registration Form")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRegistrationForm(@PathVariable Integer id, @RequestBody RegistrationFormUpdateRequest request) {
        service.updateRegistrationForm(id, request);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}
