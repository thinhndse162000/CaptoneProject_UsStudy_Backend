package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.PaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.PaymentDto;

import java.util.List;

public interface PaymentService {
    PaymentDto createPayment(PaymentRequest paymentRequest);
    List<PaymentDto> getByProgramApplication(Integer programApplication);
    List<PaymentDto> getAll();
}
