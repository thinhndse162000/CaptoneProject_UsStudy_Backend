package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.CustomerCreatRegistrationFormRequest;

public interface RegistrationFormService {
    void CreateRegistrationForm(CustomerCreatRegistrationFormRequest request);
}
