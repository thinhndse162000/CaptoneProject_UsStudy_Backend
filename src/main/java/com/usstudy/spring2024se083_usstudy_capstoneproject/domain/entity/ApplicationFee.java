package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

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
    @Column(name = "program_fee_id")
    private Integer programFeeId;
    @Column(name = "progarm_application_id")
    private Integer programApplicationId;
    private int amount;
}
