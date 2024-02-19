package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegistrationFormCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegistrationFormUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.RegistrationForm;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.RegistrationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reqistration")
public class RegistrationFormApi {
    private final RegistrationFormService service;

    @Autowired
    public RegistrationFormApi(RegistrationFormService service) {
        this.service = service;
    }

    @PostMapping("/submit")
    public void submitRegistrationForm(RegistrationFormCreateRequest request){
        service.CreateRegistrationForm(request);
    }

    @GetMapping("/customer/{id}")
    public Iterable<RegistrationForm> getRegistrationFormByCustomer(@PathVariable Integer id){
        return service.getRegistrationFormByCustomer(id);
    }

    @GetMapping("/consultant/{id}")
    public Iterable<RegistrationForm> getRegistrationFormByConsultant(@PathVariable Integer id){
        return service.getRegistrationFormByConsultant(id);
    }

    @GetMapping("/get-all")
    public Iterable<RegistrationForm> getAllRegistrationForm(){
        return service.getAll();
    }

    @PutMapping("/update/{id}")
    public void updateRegistrationForm(@PathVariable Integer id, @RequestBody RegistrationFormUpdateRequest request){
        service.updateRegistrationForm(id,request);
    }
}
