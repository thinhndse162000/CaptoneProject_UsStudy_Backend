package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Program implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "program_id")
    private Integer programId;
    @Column(name = "name_program")
    private String nameProgram;
    private String status;
    @Column(name = "create_date")
    private LocalDate createDate;
    @Column(name = "modified_date")
    private LocalDate modifiedDate;
    private Integer modifier;
    private String duration; //in days or months?
    private String description;
    private float tuition;
    private String level;

    //FK university here
    @Column(name = "university_id")
    private Integer universityId;
    //Fk Major here
    @Column(name = "major_id")
    private Integer majorId;
    //FK Semester here
    @Column(name = "semester_id")
    private Integer semesterId;
    //FK Program Type here
    @Column(name = "program_type_id")
    private Integer programTypeId;
}
