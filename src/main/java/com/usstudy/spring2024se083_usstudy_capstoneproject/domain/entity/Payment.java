package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;
//    @Column(name = "program_application_id")
//    private Integer programApplicationId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_application_id",nullable = false)
    @JsonManagedReference
    private ProgramApplication programApplication;

    private String method;
    private int amount;
    private String note;
    @Column(name = "payment_date")
    private Date paymentDate;
    @Column(name = "transaction_no")
    private Integer transactionNo;
}
