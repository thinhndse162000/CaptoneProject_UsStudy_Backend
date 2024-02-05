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
@Entity(name = "ProgramType")
@Table(name = "ProgramType")
public class ProgramType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer programTypeId;
    private String typeName;
    private String description;
}
