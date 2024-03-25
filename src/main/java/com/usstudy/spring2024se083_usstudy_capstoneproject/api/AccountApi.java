package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.Jwt.JwtTokenProvider;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.EmailRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.LoginRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.SignupRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ConsultantDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CustomerDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ConsultantService;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.CustomerService;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.EmailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/v3/account/")
@RestController
@Tag(name = "Account-API")
public class AccountApi {

    private final CustomerService service;
    private final ConsultantService consultantService;
    private final JwtTokenProvider tokenProvider;
    private final EmailService emailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public AccountApi(CustomerService customerService, ConsultantService consultantService, JwtTokenProvider tokenProvider, EmailService emailService) {
        this.service = customerService;
        this.consultantService = consultantService;
        this.tokenProvider = tokenProvider;
        this.emailService = emailService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        Customer customer = service.getCustomerByEmail(request.getEmail());
        Consultant consultant = consultantService.getConsultantByEmail(request.getEmail());


        if (customer != null && customer.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(tokenProvider.generateToken(customer));
        } else if (consultant != null && consultant.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(tokenProvider.generateTokenConsultant(consultant));
        }
        return new ResponseEntity<>("Account or Password Incorrect", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> sigup(@RequestBody SignupRequest sigupRequest) {
        service.CustomerRegistedAccount(sigupRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDto>> getAllAccountCustomer() {
        return ResponseEntity.ok(service.getAllCustomer());
    }

    @GetMapping("/consultant")
    public ResponseEntity<List<ConsultantDto>> getAllAccountConsultant() {
        return ResponseEntity.ok(consultantService.getAllConsultant());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @GetMapping("/mix")
    public ResponseEntity<List<Object>> getAllAccount() {
        List<Object> accountList = new ArrayList<>();
        List<CustomerDto> customerList = service.getAllCustomer();
        List<ConsultantDto> consultantDtoList = consultantService.getAllConsultant();
        accountList.addAll(customerList);
        accountList.addAll(consultantDtoList);
        return ResponseEntity.ok(accountList);
    }

    @GetMapping("/forgot-password")
    public ResponseEntity<?> getEmail(@RequestParam String email) {
        EmailRequest emailRequest=new EmailRequest();
        emailRequest.setRecipient(email);
        emailRequest.setSubject("forgot password");
        emailRequest.setMessageBody("Here's your password reset token");
        String result = emailService.sendEmail(emailRequest);
        return ResponseEntity.ok().body(result);
    }
}
