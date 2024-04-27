package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

//vnp_Amount=5000000
// &vnp_BankCode=NCB
// &vnp_BankTranNo=VNP14394250
// &vnp_CardType=ATM
// &vnp_OrderInfo=test+2+26%2F04%2F2024+7h30
// &vnp_PayDate=20240426193144
// &vnp_ResponseCode=00
// &vnp_TmnCode=8J40OKIL
// &vnp_TransactionNo=14394250
// &vnp_TransactionStatus=00
// &vnp_TxnRef=31859091
// &vnp_SecureHash=d0a1d2c03bbb49d419bf6f8d18c468b904259256bd37eb27965278ceacc97fbfc95a1d8a2fe7e205cda770af5634263b3204ec92bdf775e1921db62de750fa80
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VNPayPaymentRequest {
    private String vnp_Amount;
    private String vnp_BankCode;
    private String vnp_BankTranNo;
    private String vnp_CardType;
    private String vnp_OrderInfo;
    private String vnp_PayDate; //right format?
    private String vnp_ResponseCode;
    private String vnp_TmnCode;
    private String vnp_TransactionNo;
    private String vnp_TransactionStatus;
    private String vnp_TxnRef;
    private String vnp_SecureHash;
}
