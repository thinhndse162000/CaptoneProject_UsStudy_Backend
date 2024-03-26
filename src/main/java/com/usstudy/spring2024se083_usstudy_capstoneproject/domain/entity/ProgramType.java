package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Programtype")
@Table(name = "Programtype")
public class ProgramType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_type_id")
    private Integer programTypeId;
    @Column(name = "type_name")
    private String typeName;
    private String description;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "programType")
    @JsonBackReference
    private List<Program> programs;
}
