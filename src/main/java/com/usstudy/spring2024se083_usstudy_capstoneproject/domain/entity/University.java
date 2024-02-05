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
@Entity(name = "University")
@Table(name = "University")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer universityId;
    private Float tuition;
    private String description;

    //FK university type here

    //Fk state here

}
