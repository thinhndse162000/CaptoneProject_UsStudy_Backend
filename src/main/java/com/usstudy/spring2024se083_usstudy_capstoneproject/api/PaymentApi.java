package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.PaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.VNPayPaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation.VNPayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v3/payment")
@RequiredArgsConstructor
@Tag(name = "Payment-API")
public class PaymentApi {
    private final VNPayService vnPayService;
    @PostMapping("")
    public ResponseEntity<?> submitPayment(@RequestParam("amount") Long amount,
                                           @RequestParam("orderInfo") String orderInfo,
                                           @RequestBody PaymentRequest paymentRequest,
                                           HttpServletRequest request){
        return ResponseEntity.ok(vnPayService.createOrder(amount,orderInfo,request,paymentRequest));
    }
    @PostMapping("/vnpay_ipn-manual")
    public ResponseEntity<?> checkAndUpdatePayment(@RequestBody VNPayPaymentRequest vnPayPaymentRequest){
        try {
            return ResponseEntity.ok(vnPayService.checkAndUpdatePayment(vnPayPaymentRequest));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
//    @PostMapping("/test")
//    public ResponseEntity<?> test(@RequestBody VNPayPaymentRequest vnPayPaymentRequest){
//        try {
//            return ResponseEntity.ok(vnPayService.testHash(vnPayPaymentRequest));
//        }catch (Exception ex){
//            return ResponseEntity.internalServerError().body(ex.getMessage());
//        }
//    }
}
