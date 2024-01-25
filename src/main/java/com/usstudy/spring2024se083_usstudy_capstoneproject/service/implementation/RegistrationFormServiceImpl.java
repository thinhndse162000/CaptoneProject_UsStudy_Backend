package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.CustomerCreatRegistrationFormRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.RegistrationForm;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.RegistrationFormRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.RegistrationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationFormServiceImpl implements RegistrationFormService {
    private final RegistrationFormRepository registrationFormRepository;

    @Autowired
    public RegistrationFormServiceImpl(RegistrationFormRepository registrationFormRepository) {
        this.registrationFormRepository = registrationFormRepository;
    }

    @Override
    public void CreateRegistrationForm(CustomerCreatRegistrationFormRequest request) {
        RegistrationForm registrationForm = new RegistrationForm();

        registrationForm.setArea(request.getArea());
        registrationForm.setMoreInformation(request.getMoreInformation());
        registrationForm.setStudyAbroadReason(request.getStudyAbroadReason());
        registrationForm.setDestinationReason(request.getDestinationReason());
        registrationForm.setMajorChooseReason(request.getMajorChooseReason());
        registrationForm.setMajorChoose(request.getMajorChoose());
        registrationForm.setUniversityChooseReason(request.getUniversityChooseReason());
        registrationForm.setPriorityOfStudyProgram(request.getPriorityOfStudyAbroad());
        registrationForm.setBudget(request.getBudget());

        registrationFormRepository.save(registrationForm);
    }
}
