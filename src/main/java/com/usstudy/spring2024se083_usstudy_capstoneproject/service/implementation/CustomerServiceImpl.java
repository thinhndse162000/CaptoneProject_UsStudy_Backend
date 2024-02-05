package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegisterAccountRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.CustomerRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void CustomerRegistedAccount(RegisterAccountRequest request) {
        Customer customer = new Customer();

        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        customer.setGender(request.getGender());
        customer.setPassword(request.getPassword());
        customer.setDateOfBirth(request.getDateOfBirth());
        customer.setPhone(request.getPhone());

        customerRepository.save(customer);
    }
}
