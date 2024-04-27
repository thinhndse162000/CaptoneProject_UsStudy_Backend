package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.PaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.PaymentDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.PaymentMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.PaymentRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.PaymentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;

    @Override
    public PaymentDto savePayment(PaymentRequest paymentRequest) {
        return PaymentMapper.INSTANCE.toDto(
                paymentRepository.save(PaymentMapper.INSTANCE.toEntity(paymentRequest))
        );
    }
}
