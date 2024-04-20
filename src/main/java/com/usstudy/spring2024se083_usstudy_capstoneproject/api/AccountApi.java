package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.AdminAccountConfig;
import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.Jwt.JwtTokenProvider;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.ConsultantFilterRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.EmailRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.LoginRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.SignupRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.ConsultantDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CustomerDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.StaffDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ConsultantService;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.CustomerService;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.EmailService;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.StaffService;
import io.swagger.v3.oas.annotations.Operation;
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
    private final StaffService staffService;
    private final JwtTokenProvider tokenProvider;
    private final EmailService emailService;
    private final AdminAccountConfig adminAccountConfig;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public AccountApi(CustomerService customerService, ConsultantService consultantService, StaffService staffService, JwtTokenProvider tokenProvider, EmailService emailService, AdminAccountConfig adminAccountConfig) {
        this.service = customerService;
        this.consultantService = consultantService;
        this.staffService = staffService;
        this.tokenProvider = tokenProvider;
        this.emailService = emailService;
        this.adminAccountConfig = adminAccountConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        if (request.getEmail().equals(adminAccountConfig.getADMIN_EMAIL())
        && request.getPassword().equals(adminAccountConfig.getADMIN_PASSWORD()))
            return ResponseEntity.ok(tokenProvider.generateTokenAdmin(adminAccountConfig));

        Customer customer = service.getCustomerByEmail(request.getEmail());
        Consultant consultant = consultantService.getConsultantByEmail(request.getEmail());


        if (customer != null && customer.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(tokenProvider.generateToken(customer));
        } else if (consultant != null && consultant.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok(tokenProvider.generateTokenConsultant(consultant));
        }
        return new ResponseEntity<>("Email hoặc mật khẩu không đúng", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest sigupRequest) {
        service.CustomerRegistedAccount(sigupRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDto>> getAllAccountCustomer() {
        return ResponseEntity.ok(service.getAllCustomer());
    }

//    @GetMapping("/consultant")
//    public ResponseEntity<List<ConsultantDto>> getAllAccountConsultant() {
//        return ResponseEntity.ok(consultantService.getAllConsultant());
//    }
    @GetMapping("/staff/{id}")
    public ResponseEntity<StaffDto> getStaffById(@PathVariable Integer id) {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }
    @GetMapping("/staffs")
    public ResponseEntity<?> getStaffs() {
        return ResponseEntity.ok(staffService.getAllStaff());
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }
    @GetMapping("/consultant/{id}")
    public ResponseEntity<ConsultantDto> getConsultantById(@PathVariable Integer id) {
        return ResponseEntity.ok(consultantService.getConsultantById(id));
    }

    @PutMapping("/customer/{id}")
    @Operation(summary = "Update a customer", description = "Return updated customer")
    public ResponseEntity<?> putCustomer(@PathVariable Integer id,
                                         @RequestBody CustomerDto customerDto) {
        customerDto.setCustomerId(id);
        return ResponseEntity.ok(service.updateCustomer(customerDto));
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

    @GetMapping("/reset-password")
    public ResponseEntity<?> getEmail(@RequestParam String email) {
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setRecipient(email);
        emailRequest.setSubject("Reset password");
        emailRequest.setMessageBody("Click here to reset your password: http://localhost:3000/reset-password "
                + "\nHere's your password reset token: ");
        String result = emailService.sendEmail(emailRequest);
        return ResponseEntity.ok().body(result);
    }
    @Operation(summary = "Get a list of consultant with filter", description = "Return a list of consultant")
    @GetMapping("/consultants")
    public ResponseEntity<List<ConsultantDto>> getConsultantFilter(@RequestParam(required = false) String username,
                                                                   @RequestParam(required = false) String email,
                                                                   @RequestParam(required = false) String introduction,
                                                                   @RequestParam(required = false) String education,
                                                                   @RequestParam(required = false) String specialize) {
        if (username==null && email==null && introduction==null && education==null && specialize==null)
            return ResponseEntity.ok(consultantService.getAllConsultant());
        ConsultantFilterRequest request=new ConsultantFilterRequest(username,email,introduction,education,specialize);
        return ResponseEntity.ok(consultantService.getConsultantFilter(request));
    }
}
