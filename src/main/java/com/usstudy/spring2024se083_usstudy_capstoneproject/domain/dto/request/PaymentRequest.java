package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {
    private Integer programApplicationId;
    private String method;
    private int amount;
    private String note;
    //
    private Date paymentDate;
    private Integer transactionNo;
    private Integer status;
    private String img;
}
