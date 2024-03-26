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
@Entity(name = "Universitytype")
@Table(name = "Universitytype")
public class UniversityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_type_id")
    private Integer universityTypeId;
    @Column(name = "type_name")
    private String typeName;
    private String description;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "universityType")
    @JsonBackReference
    private List<University> universities;
}
