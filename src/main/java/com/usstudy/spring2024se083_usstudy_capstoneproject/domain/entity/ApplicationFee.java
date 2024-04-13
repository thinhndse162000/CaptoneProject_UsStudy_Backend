package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_fee_id")
    private Integer applicationFeeId;
//    @Column(name = "program_fee_id")
//    private Integer programFeeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_fee_id",nullable = false)
    @JsonManagedReference
    private ProgramFee programFee;

//    @Column(name = "program_application_id")
//    private Integer programApplicationId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_application_id",nullable = false)
    @JsonManagedReference
    private ProgramApplication programApplication;

//    private int amount;
}
