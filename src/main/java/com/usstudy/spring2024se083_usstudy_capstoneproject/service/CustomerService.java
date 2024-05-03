package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.CustomerRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.SignupRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.CustomerDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;

import java.util.List;

public interface CustomerService {
    void CustomerRegisterAccount(SignupRequest request);

    Customer getCustomerByEmail(String email);

    List<CustomerDto> getAllCustomer();

    CustomerDto getCustomerById(Integer customerId);
    CustomerDto updateCustomer(CustomerRequest customerRequest,Integer id);
}
