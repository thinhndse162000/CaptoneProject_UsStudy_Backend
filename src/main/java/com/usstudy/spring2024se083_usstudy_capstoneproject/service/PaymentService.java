package com.usstudy.spring2024se083_usstudy_capstoneproject.service;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.PaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.PaymentDto;

public interface PaymentService {
    PaymentDto savePayment(PaymentRequest paymentRequest);
}
