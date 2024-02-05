package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Program")
@Table(name = "Program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer programId;
    private String status;
    private LocalDate createDate;
    private LocalDate modifiedDate;
    private Integer modifier;
    private String duration; //in days or months?
    private String description;
    private float tuition;
    private String level;

    //FK university here

    //Fk Major here

    //FK Semester here

    //FK Program Type here

}
