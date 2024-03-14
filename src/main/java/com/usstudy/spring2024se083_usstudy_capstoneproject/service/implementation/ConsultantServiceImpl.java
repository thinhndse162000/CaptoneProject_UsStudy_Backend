package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Consultant;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ConsultantRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultantServiceImpl implements ConsultantService {

    private final ConsultantRepository repository;

    @Autowired
    public ConsultantServiceImpl(ConsultantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Consultant getConsultantByEmail(String email) {
        return repository.getCustomerByEmail(email);
    }
}
