package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegistrationFormCreateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegistrationFormUpdateRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.RegistrationFormDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.RegistrationForm;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.RegistrationFormMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ConsultantRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.CustomerRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.RegistrationFormRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.RegistrationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationFormServiceImpl implements RegistrationFormService {
    private final RegistrationFormRepository registrationFormRepository;
    private final ConsultantRepository consultantRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public RegistrationFormServiceImpl(RegistrationFormRepository registrationFormRepository, ConsultantRepository consultantRepository, CustomerRepository customerRepository) {
        this.registrationFormRepository = registrationFormRepository;
        this.consultantRepository = consultantRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void CreateRegistrationForm(RegistrationFormCreateRequest request) {
        RegistrationForm registrationForm = new RegistrationForm();
        Customer customer=customerRepository.findById(request.getCustomerId()).orElseThrow(
                ()->new NullPointerException("Customer not found - "+request.getCustomerId())
        );
        registrationForm.setArea(request.getArea());
        registrationForm.setMoreInformation(request.getMoreInformation());
        registrationForm.setStudyAbroadReason(request.getStudyAbroadReason());
        registrationForm.setDestinationReason(request.getDestinationReason());
        registrationForm.setMajorChooseReason(request.getMajorChooseReason());
        registrationForm.setMajorChoose(request.getMajorChoose());
        registrationForm.setUniversityChooseReason(request.getUniversityChooseReason());
        registrationForm.setPriorityOfStudyProgram(request.getPriorityOfStudyAbroad());
        registrationForm.setBudget(request.getBudget());
        registrationForm.setCustomer(customer);
        registrationFormRepository.save(registrationForm);
    }

    @Override
    public List<RegistrationFormDto> getRegistrationFormByCustomer(Integer id) {
        return registrationFormRepository.findByCustomerId(id)
                .stream().map(RegistrationFormMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RegistrationFormDto> getRegistrationFormByConsultant(Integer id) {
        return registrationFormRepository.findByConsultantId(id)
                .stream().map(RegistrationFormMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RegistrationFormDto> getAll() {
        return registrationFormRepository.findAll()
                .stream().map(RegistrationFormMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateRegistrationForm(Integer id, RegistrationFormUpdateRequest request) {
        RegistrationForm registrationForm = registrationFormRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Form not found - " + id));
        Consultant consultant = consultantRepository.findById(registrationForm.getRegistrationFormId())
                .orElseThrow(() -> new NullPointerException("Consultant not found - " + registrationForm.getRegistrationFormId()));
        registrationForm.setConsultant(consultant);
    }

}
