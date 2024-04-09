package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation.VNPayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/payment")
@RequiredArgsConstructor
@Tag(name = "Payment-API")
public class PaymentApi {
    private final VNPayService vnPayService;
    @PostMapping("")
    public ResponseEntity<?> submitPayment(@RequestParam("amount") Long amount,
                                           @RequestParam("orderInfo") String orderInfo,
                                           HttpServletRequest request){
        return ResponseEntity.ok(vnPayService.createOrder(amount,orderInfo,request));
    }
}
