package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegistrationFormCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegistrationFormUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.RegistrationFormDto;

import java.util.List;
import java.util.Optional;

public interface RegistrationFormService {
    void CreateRegistrationForm(RegistrationFormCreateRequest request);

    List<RegistrationFormDto> getRegistrationFormByCustomer(Integer id);

    List<RegistrationFormDto> getRegistrationFormByConsultant(Integer id);

    List<RegistrationFormDto> getAll();

    void updateRegistrationForm(Integer id, RegistrationFormUpdateRequest request);

    Optional getRegistraionFormById(Integer id);
}
