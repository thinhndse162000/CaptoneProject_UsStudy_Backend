package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Universitytype")
@Table(name = "Universitytype")
public class UniversityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer universityTypeId;
    private String typeName;
    private String description;
}
