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
    //?vnp_Amount=5000000
    // &vnp_BankCode=NCB
    // &vnp_BankTranNo=VNP14394721
    // &vnp_CardType=ATM
    // &vnp_OrderInfo=test+payment+27%2F04%2F2024+15h45
    // &vnp_PayDate=20240427154817
    // &vnp_ResponseCode=00
    // &vnp_TmnCode=8J40OKIL
    // &vnp_TransactionNo=14394721
    // &vnp_TransactionStatus=00
    // &vnp_TxnRef=90473062
    // &vnp_SecureHash=a592c4b2b159ac1b1818ef71883b52b6e18d43071c3868a0158adbc60b2b30c036d872be2fc36143d82ff84e76f9be80fa038922482946bafd0de21036e3b22d
    @PostMapping("/vnpay_ipn-manual")
    public ResponseEntity<?> checkAndUpdatePayment(@RequestBody VNPayPaymentRequest vnPayPaymentRequest){
        try {
            return ResponseEntity.ok(vnPayService.checkAndUpdatePayment(vnPayPaymentRequest));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
