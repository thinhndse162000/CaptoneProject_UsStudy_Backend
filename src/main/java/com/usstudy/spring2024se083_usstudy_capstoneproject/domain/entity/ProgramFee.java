package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_fee_id")
    private Integer programFeeId;
//    @Column(name = "fee_type_id")
//    private Integer feeTypeId;
//    @Column(name = "program_id")
//    private Integer programId;
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id",nullable = false)
    @JsonManagedReference
    private Program program;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_type_id",nullable = false)
    @JsonManagedReference
    private FeeType feeType;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "programFee")
    @JsonBackReference
    private List<ApplicationFee> applicationFees;
}
