package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.Jwt.JwtTokenProvider;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.LoginRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v3/account/")
@RestController
@Tag(name = "Account-API")
public class Account {

    private final CustomerService service;
    private final JwtTokenProvider tokenProvider;

    @Autowired
    public Account(CustomerService customerService, JwtTokenProvider tokenProvider) {
        this.service = customerService;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        Customer customer = service.getCustomerByEmail(request.getEmail());
        if (customer != null && customer.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(tokenProvider.generateToken(customer));
        } else
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }
}
