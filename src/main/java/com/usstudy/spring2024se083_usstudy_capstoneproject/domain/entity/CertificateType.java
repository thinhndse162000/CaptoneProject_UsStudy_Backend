package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CertificateType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_type_id")
    private Integer certificateTypeId;
    @Column(name = "certificate_name")
    private String certificateName;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "certificateType")
    @JsonBackReference
    private List<Certificate> certificates;
}
