package com.usstudy.spring2024se083_usstudy_capstoneproject.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
//    @Column(name = "university_type_id")
//    private Integer universityTypeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_type_id",nullable = false)
    @JsonManagedReference
    private UniversityType universityType;
    //Fk state here
//    @Column(name = "state_id")
//    private Integer stateId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id",nullable = false)
    @JsonManagedReference
    private State state;
    private String img;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "university")
    @JsonBackReference
    private List<Program> programs;
}
