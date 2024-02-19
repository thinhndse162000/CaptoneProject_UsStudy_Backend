package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegistrationFormCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegistrationFormUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.RegistrationForm;

public interface RegistrationFormService {
    void CreateRegistrationForm(RegistrationFormCreateRequest request);
    Iterable<RegistrationForm> getRegistrationFormByCustomer(Integer id);
    Iterable<RegistrationForm> getRegistrationFormByConsultant(Integer id);
    Iterable<RegistrationForm> getAll();
    void updateRegistrationForm(Integer id , RegistrationFormUpdateRequest request);
}
