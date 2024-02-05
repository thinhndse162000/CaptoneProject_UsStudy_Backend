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
    @Column(name = "university_id")
    private Integer universityId;
    @Column(name = "university_name")
    private String universityName;
    private Float tuition;
    private String description;
    //FK university type here
    @Column(name = "university_type_id")
    private Integer universityTypeId;
    //Fk state here
    @Column(name = "state_id")
    private Integer stateId;
}
