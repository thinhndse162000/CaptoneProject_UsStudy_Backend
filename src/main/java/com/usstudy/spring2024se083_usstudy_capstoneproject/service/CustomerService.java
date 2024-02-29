package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.RegisterAccountRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Customer;

public interface CustomerService {
    void CustomerRegistedAccount(RegisterAccountRequest request);

    Customer getCustomerByEmail(String email);
}
