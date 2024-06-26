package com.usstudy.spring2024se083_usstudy_capstoneproject.api;

import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.PaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.VNPayPaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.PaymentReportDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.PaymentService;
import com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation.VNPayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/v3/payment")
@RequiredArgsConstructor
@Tag(name = "Payment-API")
public class PaymentApi {
    private final VNPayService vnPayService;
    private final PaymentService paymentService;
    private final Integer MIN_AMOUNT=10000;
    @GetMapping("")
    @Operation(summary = "Get a list of Payments", description = "Return a list of Payments")
    public ResponseEntity<?> getPayment(){
        try {
            return ResponseEntity.ok(paymentService.getAll());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get a Payment by id", description = "Return a payment")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(paymentService.getById(id));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
    @Operation(summary = "Get a list of Payments by program application id", description = "Return a list of Payments")
    @GetMapping("/program-application/{id}")
    public ResponseEntity<?> getPaymentByProgramApplication(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(paymentService.getByProgramApplication(id));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
    @Operation(summary = "Create a VNPay link and save a temp payment", description = "Return a url")
    @PostMapping("/vnpay")
    public ResponseEntity<?> submitPayment(@RequestParam("amount") Long amount,
                                           @RequestParam("orderInfo") String orderInfo,
                                           @RequestBody PaymentRequest paymentRequest,
                                           HttpServletRequest request){
        if (amount<MIN_AMOUNT)
            return ResponseEntity.badRequest().body("Amount must be more than"+MIN_AMOUNT);
        return ResponseEntity.ok(vnPayService.createOrder(amount,orderInfo,request,paymentRequest));
    }
    @PostMapping("/vnpay-ipn-manual")
    @Operation(summary = "Update temp payment", description = "Return update payment")
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
    @PostMapping("")
    @Operation(summary = "Create a new payment ( for other type of payment)", description = "Return new payment")
    public ResponseEntity<?> postPayment(@RequestBody PaymentRequest paymentRequest){
        try {
            return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
    @PutMapping("/{id}")
    @Operation(summary = "Update payment ( amount, note, method only )", description = "Return updated payment")
    public ResponseEntity<?> putPayment(@RequestBody PaymentRequest paymentRequest,
                                        @PathVariable Integer id){
        try {
            return ResponseEntity.ok(paymentService.updatePayment(paymentRequest,id));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
    @GetMapping("/report")
    @Operation(summary = "Get report from start date to end date (date format yyyy-mm-dd)", description = "Return a report")
    public ResponseEntity<PaymentReportDto> getReport(@RequestParam Date startDate,
                                                      @RequestParam Date endDate){
        return ResponseEntity.ok(paymentService.getReport(startDate,endDate));
    }
}
