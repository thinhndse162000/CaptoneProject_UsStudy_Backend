package com.usstudy.spring2024se083_usstudy_capstoneproject.service.implementation;

import com.usstudy.spring2024se083_usstudy_capstoneproject.configuration.VNPayConfig;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.PaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request.VNPayPaymentRequest;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.response.PaymentDto;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity.Payment;
import com.usstudy.spring2024se083_usstudy_capstoneproject.domain.utils.PaymentMapper;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.PaymentRepository;
import com.usstudy.spring2024se083_usstudy_capstoneproject.repository.ProgramApplicationRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class VNPayService {
    private final PaymentRepository paymentRepository;
    private final ProgramApplicationRepository programApplicationRepository;
    public String createOrder(Long amount, String orderInfo, HttpServletRequest request,PaymentRequest paymentRequest){
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", VNPayConfig.vnp_Version);
        vnp_Params.put("vnp_Command", VNPayConfig.vnp_Command);
        vnp_Params.put("vnp_TmnCode", VNPayConfig.vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount*100));
        vnp_Params.put("vnp_CurrCode", VNPayConfig.vnp_CurrCode);
        String vnp_TxnRef=VNPayConfig.getRandomNumber(8);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", orderInfo);
        //vnp_Params.put("vnp_BankCode", "NCB");
        vnp_Params.put("vnp_OrderType", "other");

        String locate = "vn";
        vnp_Params.put("vnp_Locale", locate);
        //vnp_Params.put("vnp_BankCode",VNPayConfig.vnp_BankCode);

//        if (urlReturn!=null)
//        {
//            //urlReturn += VNPayConfig.vnp_Returnurl;
            vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_Returnurl);
//        }
        vnp_Params.put("vnp_IpAddr", VNPayConfig.getIpAddress(request));
//        vnp_Params.put("vnp_IpAddr", "127.0.0.1");
        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

//        cld.add(Calendar.MINUTE, 15);
//        String vnp_ExpireDate = formatter.format(cld.getTime());
//        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                try {
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = VNPayConfig.hmacSHA512(VNPayConfig.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VNPayConfig.vnp_PayUrl + "?" + queryUrl;
        //check in DB
        if (programApplicationRepository.findById(paymentRequest.getProgramApplicationId()).isEmpty())
            return "Program Application id "+paymentRequest.getProgramApplicationId()+" not found";
        //set payment request
        paymentRequest.setAmount(amount.intValue());
        paymentRequest.setTransactionNo(Integer.parseInt(vnp_TxnRef));
        paymentRequest.setMethod("VNPay");
        //save payment request
        paymentRepository.save(PaymentMapper.INSTANCE.toEntity(paymentRequest));

        return paymentUrl;
    }
    public Object checkAndUpdatePayment(VNPayPaymentRequest vnPayPaymentRequest){
//        Map fields = mapVNPayPaymentRequest(vnPayPaymentRequest);
//        if (fields.containsKey("vnp_SecureHashType"))
//        {
//            fields.remove("vnp_SecureHashType");
//        }
//        if (fields.containsKey("vnp_SecureHash"))
//        {
//            fields.remove("vnp_SecureHash");
//        }
        Payment payment=paymentRepository.getPaymentByTransactionNo(Integer.parseInt(vnPayPaymentRequest.getVnp_TxnRef()));
        if (payment==null)
            return "No Payment with TransactionNo "+vnPayPaymentRequest.getVnp_TxnRef()+" exist";
        if (payment.getAmount()*100!=Integer.parseInt(vnPayPaymentRequest.getVnp_Amount()))
            return "Payment amount do not match with database";
        //String checkHash=VNPayConfig.hashAllFields(fields);
//        if (!checkHash.equals(vnPayPaymentRequest.getVnp_SecureHash()))
//            return "Secure hash do not match "+checkHash;
        payment.setPaymentDate(Date.valueOf(vnPayPaymentRequest.getVnp_PayDate()));
        payment.setNote("Paid");
        return PaymentMapper.INSTANCE.toDto(
                paymentRepository.save(payment)
        );
    }
//    private Map mapVNPayPaymentRequest(VNPayPaymentRequest request){
//        Map map = new TreeMap();
//        map.put("vnp_Amount",request.getVnp_Amount());
//        map.put("vnp_BankCode",request.getVnp_BankCode());
//        map.put("vnp_BankTranNo",request.getVnp_BankTranNo());
//        map.put("vnp_CardType",request.getVnp_CardType());
//        map.put("vnp_OrderInfo",request.getVnp_OrderInfo());
//        map.put("vnp_PayDate",request.getVnp_PayDate());
//        map.put("vnp_ResponseCode",request.getVnp_ResponseCode());
//        map.put("vnp_TmnCode",request.getVnp_TmnCode());
//        map.put("vnp_TransactionNo",request.getVnp_TransactionNo());
//        map.put("vnp_TransactionStatus",request.getVnp_TransactionStatus());
//        map.put("vnp_TxnRef",request.getVnp_TxnRef());
//        return map;
//    }
}
