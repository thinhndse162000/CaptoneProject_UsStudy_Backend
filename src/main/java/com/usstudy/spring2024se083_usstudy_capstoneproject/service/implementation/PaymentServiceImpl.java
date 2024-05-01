package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.PaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.PaymentDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.PaymentReportDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Payment;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.PaymentMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.PaymentRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.PaymentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Override
    public PaymentDto createPayment(PaymentRequest paymentRequest) {
        paymentRequest.setTransactionNo(null);
        paymentRequest.setPaymentDate(new Date(System.currentTimeMillis()));
        paymentRequest.setStatus(0);
        return PaymentMapper.INSTANCE.toDto(
                paymentRepository.save(PaymentMapper.INSTANCE.toEntity(paymentRequest))
        );
    }

    @Override
    public PaymentDto updatePayment(PaymentRequest paymentRequest,Integer id) {
        Payment payment=paymentRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("No Payment with id "+id));
        payment.setNote(paymentRequest.getNote());
        payment.setMethod(paymentRequest.getMethod());
        payment.setAmount(paymentRequest.getAmount());
        payment.setImg(paymentRequest.getImg());
        payment.setStatus(paymentRequest.getStatus());
        return PaymentMapper.INSTANCE.toDto(
                paymentRepository.save(payment)
        );
    }

    @Override
    public List<PaymentDto> getByProgramApplication(Integer programApplication) {
        return paymentRepository.getPaymentByProgramApplicationProgramApplicationId(programApplication)
                .stream().map(PaymentMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentDto> getAll() {
        return paymentRepository.findAll().stream().map(PaymentMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentReportDto getReport(Date startDate, Date endDate) {
        PaymentReportDto paymentReportDto=new PaymentReportDto();
        paymentReportDto.setNumberOfPayment(paymentRepository.getNumberOfPayment(startDate,endDate,null));
        paymentReportDto.setSuccessPayment(paymentRepository.getNumberOfPayment(startDate,endDate,1));
        paymentReportDto.setNotVerifyPayment(paymentRepository.getNumberOfPayment(startDate,endDate,0));
        paymentReportDto.setTotal(paymentRepository.getTotalAmount(startDate,endDate,1));
        return paymentReportDto;
    }

    @Override
    public PaymentDto getById(Integer id) {
        return paymentRepository.findById(id).map(PaymentMapper.INSTANCE::toDto)
                .orElseThrow(() -> new NullPointerException("No Payment id "+id));
    }
}
